package com.example.first_aid.FirstAid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.first_aid.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class FirstAidPage1_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_aid_page1_2);

            Log.d("성공", "썩씨딩 유");
            //서버에서 이미지 연결
            StorageReference storageReference = FirebaseStorage.getInstance().getReference();

            ImageView baby1 = findViewById((R.id.Baby1));
            ImageView baby2 =findViewById((R.id.Baby2));
            ImageView baby3 =findViewById((R.id.Baby3));
            ImageView baby4 =findViewById((R.id.Baby4));
            ImageView baby5 =findViewById((R.id.Baby5));

            gif_image_make(storageReference, "소아 심폐소생술/소아_심폐소생술_1.gif", baby1);

            gif_image_make(storageReference, "소아 심폐소생술/소아_심폐소생술_2.gif", baby2);

            gif_image_make(storageReference, "소아 심폐소생술/소아_심폐소생술_3.gif", baby3);

            gif_image_make(storageReference, "소아 심폐소생술/소아_심폐소생술_4.gif", baby4);

            gif_image_make(storageReference, "소아 심폐소생술/소아_심폐소생술_5.gif", baby5);

        }
    public void gif_image_make(StorageReference storageReference ,String Path, ImageView imageView){
        StorageReference photoReference = storageReference.child(Path);
        photoReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Log.d("성공", uri.toString());
                Glide.with(FirstAidPage1_2.this).asGif()
                        .load(uri)
                        .into(imageView);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                Log.d("Test", " Failed!");
            }
        });
    }
    }




