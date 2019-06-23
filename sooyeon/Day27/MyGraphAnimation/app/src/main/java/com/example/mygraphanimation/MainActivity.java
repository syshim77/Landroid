package com.example.mygraphanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Animation grow;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grow = AnimationUtils.loadAnimation(this, R.anim.grow);

        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        progressBar.setAnimation(grow);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        Toast.makeText(this, "onWindowChanged() 호출됨: " + hasFocus, Toast.LENGTH_LONG).show();

        if (hasFocus) {
            grow.start();
        } else {
            grow.reset();
        }
    }
}
