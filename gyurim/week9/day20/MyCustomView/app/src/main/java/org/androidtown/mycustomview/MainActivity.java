package org.androidtown.mycustomview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout container = (LinearLayout) findViewById(R.id.container);

        MyView view = new MyView(this);
        /*이 Activity를 해당 View의 context 객체로 사용*/
        view.setBackgroundColor(Color.CYAN);
        container.addView(view);

    }
}
