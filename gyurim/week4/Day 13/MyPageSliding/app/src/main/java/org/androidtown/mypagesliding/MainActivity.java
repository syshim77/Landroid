package org.androidtown.mypagesliding;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout slidingPanel;
    Button button;
    Animation translateleftAnim;
    Animation translaterightAnim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        translateleftAnim = AnimationUtils.loadAnimation(this, R.anim.translate_left);
        translaterightAnim = AnimationUtils.loadAnimation(this, R.anim.translate_right);

        /* animation이 시작할 때, "열기" | animation이 끝날 때, "닫기"*/
        translateleftAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                /*animation이 끝나는 시점*/
                button.setText("닫기");
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        slidingPanel = findViewById(R.id.slidingPanel);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slidingPanel.setVisibility(View.VISIBLE);
                slidingPanel.startAnimation(translateleftAnim);
            }
        });

    }
}
