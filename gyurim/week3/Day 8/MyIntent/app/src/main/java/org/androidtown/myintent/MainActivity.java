package org.androidtown.myintent;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final int ACTIVITY_MENU = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButton1Clicked(View V){
//        1-1) 전화 거는 action
//        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:010-1000-1000"));
//        startActivity(intent);

//       2-1) menuactivity를 실제 class 참조
//        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
        // 시스템으로 전달할때, Intent로 전달해야한다. 그 다음 startActivity
//        startActivityForResult(intent, ACTIVITY_MENU); // ACTIVITY_MENU 대신 상수의 요청코드 들어가도 됨

//       2-2) 동적으로 처리하고 싶을때 (이름만 지정)
        Intent intent = new Intent();
        ComponentName name = new ComponentName("org.androidtown.myintent",
                "org.androidtown.myintent.MenuActivity");
        intent.setComponent(name);
        intent.putExtra("title","소녀시대");
        intent.putExtra("age", 20);
        startActivityForResult(intent, ACTIVITY_MENU);

        Person person01 = new Person("트와이스", 21);
        intent.putExtra("person", person01);



    }
}
