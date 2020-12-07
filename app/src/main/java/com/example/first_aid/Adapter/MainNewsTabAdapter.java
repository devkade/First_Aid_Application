package com.example.first_aid.Adapter;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.first_aid.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.bumptech.glide.Glide;

import static android.content.ContentValues.TAG;
import static androidx.core.content.ContextCompat.startActivity;


public class MainNewsTabAdapter extends RecyclerView.Adapter<MainNewsTabAdapter.MyViewHolder> {
    private String[] mDataset;
    private String[] mDataset3 = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17"};
    private String[] mDataset2;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public CardView mCardView;
        public TextView mTextView;
        public TextView mReporter;
        public ImageView mImageView;
        public MyViewHolder(View v) {
            super(v);

            mCardView = (CardView) v.findViewById(R.id.card_view);

            mTextView = (TextView) v.findViewById(R.id.tv_text);
            mReporter = (TextView) v.findViewById(R.id.tv_blah);
            mImageView = (ImageView) v.findViewById(R.id.iv_image);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MainNewsTabAdapter(String[] myDataset) {
        for(int i = 0; i < 17; i++) {
            mDataset3[i] = myDataset[i];
        }
        mDataset = mDataset3;
        mDataset2 = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MainNewsTabAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                              int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        if(position < 17) {
            Log.d(TAG, mDataset[position]);
            holder.mTextView.setText(mDataset2[position]);
            holder.mReporter.setText(mDataset2[position + 34]);
            holder.mCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String currentValue = mDataset2[position];
                    String url = mDataset2[position + 17];
                    Log.d("CardView", "CardView Clicked: " + currentValue);
                    Intent myIntent;
                    myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    view.getContext().startActivity(myIntent);
                }
            });

            FirebaseStorage storage = FirebaseStorage.getInstance("gs://design-thinking-51c43.appspot.com");
            StorageReference storageRef = storage.getReference();
            storageRef.child("NewsImage/"+ mDataset2[position + 51] +".jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri uri) {
                    //이미지 로드 성공시

                    Glide.with(holder.itemView)
                            .load(uri)
                            .into(holder.mImageView);

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception exception) {
                    //이미지 로드 실패시
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}