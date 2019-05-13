package com.example.myanim;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textView);
    }

    public void onButton1Clicked(View v) {
        Animation translate = AnimationUtils.loadAnimation(this, R.anim.translate);
        //textView.startAnimation(translate);

        ViewGroup container = (ViewGroup)findViewById(R.id.container);
        container.startAnimation(translate);
    }
}
