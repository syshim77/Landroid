package com.example.mythread;

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

    private static final String TAG = "MainActivity";
    TextView textView;
    //ResponseHandler handler = new ResponseHandler();
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textView);
    }

    public void onButton1Clicked(View v) {
        Log.d(TAG, "첫 번째 버튼 클릭됨.");

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("알림");
        builder.setMessage("데이터를 저장 하시겠습니까?");
        builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                textView.setText("thread 실행 시작함.");
                RequestThread thread = new RequestThread();
                thread.start(); // run() 호출됨
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    class RequestThread extends Thread {
        public void run() {
            for (int i=0; i<100; i++) {
                println("#" + i + ": 호출됨.");

                try {
                    Thread.sleep(500);
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public void println(final String data) {
            Log.d(TAG, data);

            //textView.setText(data);
//            Message message = handler.obtainMessage();
//            Bundle bundle = new Bundle();
//            bundle.putString("data", data);
//            message.setData(bundle);
//
//            handler.sendMessage(message);
            handler.postDelayed(new Runnable() {   // handler 쪽으로 넘어가서 순서대로 처리됨
                @Override
                public void run() {
                    textView.setText(data);
                }
            }, 10000);
        }
    }

//    class ResponseHandler extends Handler {
//        @Override
//        public void handleMessage(Message msg) {    // main thread
//            //super.handleMessage(msg);
//            Bundle bundle = msg.getData();
//            String data = bundle.getString("data");
//
//            textView.setText(data);
//        }
//    }
}
