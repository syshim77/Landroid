package com.example.mytwinanimation;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    ConstraintLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView)findViewById(R.id.imageView);
        container = (ConstraintLayout)findViewById(R.id.container);
    }

    public void onButton1Clicked(View v) {
        Animation scale = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale);
        final Animation translate = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translate);

        scale.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //imageView.startAnimation(translate);
                container.startAnimation(translate);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        //imageView.startAnimation(scale);
        container.startAnimation(scale);
    }
}
