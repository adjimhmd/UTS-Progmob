package com.dicoding.picodiploma.myrecyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.sql.Struct;

public class GalleryActivity extends AppCompatActivity {
    private static final String TAG = "GalleryActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        TextView text = (TextView) findViewById(R.id.image_description);
        TextView text_dua = (TextView) findViewById(R.id.image_description_dua);
        TextView text_tiga = (TextView) findViewById(R.id.image_description_tiga);
        ImageView image = findViewById(R.id.image);

        Intent intent = getIntent();

        String str = intent.getStringExtra("image_name");
        text.setText(str);

        String str_dua = intent.getStringExtra("image_remarks");
        text_dua.setText(str_dua);

        String str_tiga = intent.getStringExtra("image_deskripsi");
        text_tiga.setText(str_tiga);

        String image_satu = intent.getStringExtra("image_url");
        Glide.with(this)
                .load(image_satu)
                .apply(new RequestOptions().override(640, 640))
                .into(image);
    }
}
