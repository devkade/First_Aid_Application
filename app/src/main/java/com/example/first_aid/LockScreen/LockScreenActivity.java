package com.example.first_aid.LockScreen;

import android.app.Activity;
import android.app.Application;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.first_aid.MainActivity;
import com.example.first_aid.R;

import android.content.ClipData;
import android.content.ClipDescription;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnDragListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.first_aid.database.oxquiz;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.content.res.ResourcesCompat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class LockScreenActivity extends Activity {
    private ImageView mImg;
    private static final String IMAGEVIEW_TAG = "unlock_btn";
    private Intent serviceIntent;
    private int layout;
    private String answer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        int rand = random.nextInt(2) + 1;

        if(rand == 1){
            layout = R.layout.activity_lock_screen;
        }else if(rand == 2){
            layout = R.layout.activity_lock_screen_2;
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            setShowWhenLocked(true);
            KeyguardManager keyguardManager = (KeyguardManager) getSystemService(Context.KEYGUARD_SERVICE);
            keyguardManager.requestDismissKeyguard(this, null);
        }else{
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
                    | WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
        }
        setContentView(layout);


        PowerManager pm = (PowerManager) getApplicationContext().getSystemService(POWER_SERVICE);
        boolean isWhiteListing = false;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            isWhiteListing = pm.isIgnoringBatteryOptimizations(getApplicationContext().getPackageName());
        }
        if (!isWhiteListing) {
            Intent intent = new Intent();
            intent.setAction(android.provider.Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS);
            intent.setData(Uri.parse("package:" + getApplicationContext().getPackageName()));
            startActivity(intent);
        }

        if (RealService.serviceIntent==null) {
            serviceIntent = new Intent(this, RealService.class);
            startService(serviceIntent);
        } else {
            serviceIntent = RealService.serviceIntent;//getInstance().getApplication();
            //Toast.makeText(getApplicationContext(), "already", Toast.LENGTH_LONG).show();
        }

        //퀴즈 액티비티 실행
        if(rand == 1) {
            mImg = (ImageView) findViewById(R.id.unlock_btn);
            mImg.setTag(IMAGEVIEW_TAG);

            mImg.setOnLongClickListener(new LongClickListener());

            findViewById(R.id.x).setOnDragListener(new DragListener());
            findViewById(R.id.o).setOnDragListener(new DragListener());
            findViewById(R.id.nothing).setOnDragListener(new DragListener());


            oxquiz oxquiz=new oxquiz();
            TextView textView = (TextView) findViewById(R.id.lock_quiz);
            List<List<String>> setquiz = new ArrayList<List<String>>();
            int quiz_cat = random.nextInt(2) + 1;
            int quiz_num = 0;

            if(quiz_cat == 1){
                setquiz = oxquiz.getoxA();
                quiz_num = random.nextInt(setquiz.size());
            }
            else if(quiz_cat == 2){
                setquiz = oxquiz.getoxB();
                quiz_num = random.nextInt(setquiz.size());
            }
            /*
            else if(quiz_cat == 3){
                setquiz = oxquiz.getoxC();
                quiz_num = random.nextInt(setquiz.size());
            }
            else if(quiz_cat == 4){
                setquiz = oxquiz.getoxD();
                quiz_num = random.nextInt(setquiz.size());
            }
            else if(quiz_cat == 5){
                setquiz = oxquiz.getoxE();
                quiz_num = random.nextInt(setquiz.size());
            }
            else if(quiz_cat == 6){
                setquiz = oxquiz.getoxF();
                quiz_num = random.nextInt(setquiz.size());
            }
             */
            textView.setText(setquiz.get(quiz_num).get(2));

            answer = setquiz.get(quiz_num).get(3);

        }

    }

    private final class LongClickListener implements OnLongClickListener {

        public boolean onLongClick(View view) {

            // 태그 생성
            ClipData.Item item = new ClipData.Item((CharSequence) view.getTag());

            String[] mimeTypes = { ClipDescription.MIMETYPE_TEXT_PLAIN };
            ClipData data = new ClipData(view.getTag().toString(), mimeTypes, item);
            DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);

            view.startDragAndDrop(data, // data to be dragged
                    shadowBuilder, // drag shadow
                    view, // 드래그 드랍할  Vew
                    0 // 필요없은 플래그
            );

            view.setVisibility(View.INVISIBLE);
            return true;
        }
    }

    class DragListener implements OnDragListener {
        Drawable normalShape = ResourcesCompat.getDrawable(getResources(), R.drawable.lockscreen_normal_shape, null);
        Drawable targetShape = ResourcesCompat.getDrawable(getResources(), R.drawable.lockscreen_target_shape, null);



        public boolean onDrag(View v, DragEvent event) {
            int answerID;
            int worngID;
            if(answer == "O"){
                answerID = R.id.o;
                worngID = R.id.x;
            }
            else{
                answerID = R.id.x;
                worngID = R.id.o;
            }


            // 이벤트 시작
            switch (event.getAction()) {

                // 이미지를 드래그 시작될때
                case DragEvent.ACTION_DRAG_STARTED:
                    Log.d("DragClickListener", "ACTION_DRAG_STARTED");
                    break;

                // 드래그한 이미지를 옮길려는 지역으로 들어왔을때
                case DragEvent.ACTION_DRAG_ENTERED:
                    Log.d("DragClickListener", "ACTION_DRAG_ENTERED");
                    // 이미지가 들어왔다는 것을 알려주기 위해 배경이미지 변경
                    if(v != findViewById(R.id.nothing)){
                        v.setBackground(targetShape);
                    }
                    break;

                // 드래그한 이미지가 영역을 빠져 나갈때
                case DragEvent.ACTION_DRAG_EXITED:
                    Log.d("DragClickListener", "ACTION_DRAG_EXITED");

                    if(v != findViewById(R.id.nothing)){
                        v.setBackground(normalShape);
                    }
                    break;

                // 이미지를 드래그해서 드랍시켰을때
                case DragEvent.ACTION_DROP:
                    Log.d("DragClickListener", "ACTION_DROP");

                    if (v == findViewById(worngID)) {
                        View view = (View) event.getLocalState();
                        ViewGroup viewgroup = (ViewGroup) view.getParent();
                        viewgroup.removeView(view);

                        sendNotification("오답입니다.");

                        ConstraintLayout containView = (ConstraintLayout) v;
                        containView.addView(view);
                        view.setVisibility(View.VISIBLE);

                        finish();

                    }else if (v == findViewById(answerID)) {
                        View view = (View) event.getLocalState();
                        ViewGroup viewgroup = (ViewGroup) view.getParent();
                        viewgroup.removeView(view);

                        sendNotification("정답입니다.");

                        ConstraintLayout containView = (ConstraintLayout) v;
                        containView.addView(view);
                        view.setVisibility(View.VISIBLE);

                        finish();

                    }else if (v == findViewById(R.id.nothing) | v == findViewById(R.id.o) | v == findViewById(R.id.x)) {
                        View view = (View) event.getLocalState();
                        ViewGroup viewgroup = (ViewGroup) view.getParent();
                        viewgroup.removeView(view);

                        ConstraintLayout containView = (ConstraintLayout) findViewById(R.id.base);
                        containView.addView(view);
                        view.setVisibility(View.VISIBLE);

                    }else {
                        View view = (View) event.getLocalState();
                        view.setVisibility(View.VISIBLE);
                        Context context = getApplicationContext();

                        ConstraintLayout containView = (ConstraintLayout) v;
                        containView.addView(view);
                        break;
                    }
                    break;

                case DragEvent.ACTION_DRAG_ENDED:
                    Log.d("DragClickListener", "ACTION_DRAG_ENDED");
                    if(v != findViewById(R.id.nothing)) {
                        v.setBackground(normalShape); // go back to normal shape
                    }
                default:
                    break;
            }
            return true;
        }
    }

    private void sendNotification(String messageBody) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0  /*Request code*/ , intent, PendingIntent.FLAG_ONE_SHOT);

        String channelId = "fcm_default_channel";//getString(R.string.default_notification_channel_id);
        Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(this, channelId)
                        .setSmallIcon(R.mipmap.ic_launcher)//drawable.splash)
                        .setContentTitle("Service test")
                        .setContentText(messageBody)
                        .setAutoCancel(true)
                        .setPriority(Notification.PRIORITY_HIGH)
                        .setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        // Since android Oreo notification channel is needed.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(channelId,"Channel human readable title", NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
        }

        notificationManager.notify(0  /*ID of notification*/ , notificationBuilder.build());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (serviceIntent!=null) {
            stopService(serviceIntent);
            serviceIntent = null;
        }
        this.finish();
    }

}
