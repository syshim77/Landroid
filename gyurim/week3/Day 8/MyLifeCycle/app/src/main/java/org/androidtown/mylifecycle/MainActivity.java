package org.androidtown.mylifecycle;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(getApplicationContext(),"onCreate() 호출됨.", Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onStart() {
        Toast.makeText(getApplicationContext(),"onStart() 호출됨.", Toast.LENGTH_LONG).show();

        super.onStart();
    }

    @Override
    protected void onStop() {
        Toast.makeText(getApplicationContext(),"onStop() 호출됨.", Toast.LENGTH_LONG).show();

        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Toast.makeText(getApplicationContext(),"onDestroy() 호출됨.", Toast.LENGTH_LONG).show();

        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Toast.makeText(getApplicationContext(),"onPause() 호출됨.", Toast.LENGTH_LONG).show();
        saveScore();

        super.onPause();
    }

    @Override
    protected void onResume() {
        Toast.makeText(getApplicationContext(),"onResume() 호출됨.", Toast.LENGTH_LONG).show();
        loadScore();
        super.onResume();
    }

    private void saveScore(){
        SharedPreferences pref = getSharedPreferences("gostop", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("score",10000);
        editor.commit(); // 정보가 저장됨
    }

    private void loadScore(){
        SharedPreferences pref = getSharedPreferences("gostop", Activity.MODE_PRIVATE);
        int score =  pref.getInt("score", 0);
        Toast.makeText(getApplicationContext(),"읽어온 점수 : "+score, Toast.LENGTH_LONG).show();
        // 앱이 시작되는 시점에서 점수를 불러옴
    }
}
