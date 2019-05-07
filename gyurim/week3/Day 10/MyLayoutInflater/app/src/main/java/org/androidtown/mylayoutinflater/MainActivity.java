package org.androidtown.mylayoutinflater;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButton1Clicked(View v){
        SubLayout layout1 = new SubLayout(this);
        LinearLayout container = (LinerLayout) findViewById(R.id.container);
        container.addView(layout1);
    }
}
