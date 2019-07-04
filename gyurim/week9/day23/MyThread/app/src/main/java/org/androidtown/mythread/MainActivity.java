package org.androidtown.mythread;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    //ResponseHandler handler = new ResponseHandler();
    Handler handler = new Handler(); // 기본 Handler 객체

    private static final String TAG ="MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
    }

    public void onButton1Clicked(View v){
        Log.d(TAG, "첫번째 버튼 클릭됨. ");

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("알림");
        builder.setMessage("네트워크 요청(데이터 저장)을 하시겠습니까?");

        // 예 버튼이 눌리면
        builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                textView.setText("스레드 시작함.");

                RequestThread thread = new RequestThread();
                thread.start(); //thread는 start로 호출됨
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    class RequestThread extends Thread {
        public void run(){ // thread는 run으로 실행됨
            for(int i=0;i < 100;i++){
                println("#" + i + " : 호출됨");

                try{
                    Thread.sleep(500);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        }

        public void println(final String data){ // final은 정수로도 사용할 수 있다는 뜻
            Log.d(TAG,data);

            // textView.setText(data);
            // thread 안에서 textView라는 UI 객체를 접근하기 때문에 (data)하면 앱이 비정상 종료됨
            // 따라서 순서대로 실행할 수 있게 해야함 -> Handler (큐의 역할)

            /*

            //message 객체 넘겨주는 방법
            Message message = handler.obtainMessage();


            Bundle bundle = new Bundle();
            bundle.putString("data", data);
            message.setData(bundle);

            handler.sendMessage(message);*/

            handler.postDelayed(new Runnable() {
                // Runnable 쓰면 msg 객체를 넘겨주지 않아도 됨 (:handler를 가장 편리하게 쓰는 방법)
                @Override
                public void run() {
                    textView.setText(data);
                }
            }, 10000); // 10초 뒤에 실행
        }
    }
    /*class ResponseHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            Bundle bundle = msg.getData();
            String data = bundle.getString("data");
            textView.setText(data);

        }
    }*/
}
