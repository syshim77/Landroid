package org.androidtown.myanim;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
    }

    public void onButton1Clicked(View v){

        Animation translate = AnimationUtils.loadAnimation(this, R.anim.scale);
        //textView.startAnimation(scale);
        /*애니메이션 로딩*/
        ViewGroup container = findViewById(R.id.container);
        container.startAnimation(translate);
    }
}
