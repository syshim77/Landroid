package com.example.myframeanimation;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    AnimationDrawable drawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView)findViewById(R.id.imageView);

        Resources res = getResources();
        Drawable frame1 = res.getDrawable(R.drawable.emoticon1);
        Drawable frame2 = res.getDrawable(R.drawable.emoticon2);
        Drawable frame3 = res.getDrawable(R.drawable.emoticon3);
        Drawable frame4 = res.getDrawable(R.drawable.emoticon4);

        int duration = 500;
        drawable = new AnimationDrawable();
        drawable.addFrame(frame1, duration);
        drawable.addFrame(frame2, duration);
        drawable.addFrame(frame3, duration);
        drawable.addFrame(frame4, duration);
        drawable.setOneShot(false);
    }

    public void onButton1Clicked() {
        imageView.setBackground(drawable);

        drawable.setVisible(true, true);
        drawable.start();
    }
}
