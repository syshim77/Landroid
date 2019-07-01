package org.androidtown.mytweenanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);
        container = (LinearLayout) findViewById(R.id.container);
    }

    public void onButton1Clicked(View v){
        Animation scale = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale);
        final Animation translate = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translate);
        //animation, translate 객체 로딩

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

        //imageView.startAnimation(scale); // imageView에 scale라는 animation 적용
        container.startAnimation(scale); // 화면 전체가 확대
    }
}
