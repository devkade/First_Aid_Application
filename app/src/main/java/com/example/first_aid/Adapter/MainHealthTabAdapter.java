package com.example.first_aid.Adapter;

import android.content.Context;
import android.content.Intent;
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

import com.bumptech.glide.Glide;
import com.example.first_aid.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;


public class MainHealthTabAdapter extends RecyclerView.Adapter<MainHealthTabAdapter.MyViewHolder> {
    private String[] mDataset = {"1", "2", "3", "4", "5", "6", "7", "8"};
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
    public MainHealthTabAdapter(String[] myDataset) {
        for(int i = 0; i < 8; i++) {
            mDataset[i] = myDataset[i];
        }
        mDataset2 = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MainHealthTabAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                              int viewType) {
        // create a new view
        Context mContext  = parent.getContext();
        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.card_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MainHealthTabAdapter.MyViewHolder vh = new MainHealthTabAdapter.MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MainHealthTabAdapter.MyViewHolder holder, final int position) {
        holder.mTextView.setText(mDataset2[position]);
        holder.mReporter.setText(mDataset2[position + 16]);
        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = mDataset2[position + 8];
                Intent myIntent;
                myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                view.getContext().startActivity(myIntent);
            }
        });

        FirebaseStorage storage = FirebaseStorage.getInstance("gs://design-thinking-51c43.appspot.com");
        StorageReference storageRef = storage.getReference();
        storageRef.child("HealthNewsImage/"+ mDataset2[position + 24] +".jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
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

    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}
