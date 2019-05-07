package com.example.myintent;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final int REQ_MENU = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButton1Clicked(View v) {
        //Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 010-1000-1000"));
        //startActivity(intent);

        //Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
        //startActivityForResult(intent, REQ_MENU);

        // 동적으로 처리할 때 사용하는 방법(위 코드와 같은 결과)
        Intent intent = new Intent();
        ComponentName name = new ComponentName("com.example.myintent", "com.example.myintent.MenuActivity");

        intent.setComponent(name);
        intent.putExtra("title", "소녀시대");
        intent.putExtra("age", 20);

        Person person01 = new Person("걸스데이", 21);
        intent.putExtra("person", person01);

        startActivityForResult(intent, REQ_MENU);
    }
}
