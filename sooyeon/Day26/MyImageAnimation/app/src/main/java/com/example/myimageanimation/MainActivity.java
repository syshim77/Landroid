package com.example.myimageanimation;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {

    int[] imageArray = {R.drawable.emoticon1, R.drawable.emoticon2, R.drawable.emoticon3, R.drawable.emoticon4};
    Switch imageSwitcher;
    Handler handler = new Handler();
    ImageThread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageSwitcher = (Switch)findViewById(R.id.switch1);

        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                return imageView;
            }
        });

        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);

        imageSwitcher.setInAnimation(in);
        imageSwitcher.setOutAnimation(out);
    }

    public void onButton1Clicked(View v) {
        thread = new ImageThread();
        thread.start();
    }

    public void onButton2Clicked(View v) {
        if (thread != null) {
            thread.halt();
            thread = null;
        }
    }

    class ImageThread extends Thread {
        boolean running = false;
        int index = 0;
        int interval = 800;

        public void run() {
            running = true;

            while(running) {
                handler.post(new Runnable() {
                    public void run() {
                        imageSwitcher.setImageResource(imageArray[index]);
                        imageSwitcher.invalidate();
                    }
                });

                try {
                    Thread.sleep(interval);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                index++;
                if (index > 3) {
                    index = 0;
                }
            }
        }

        public void halt() {
            running = false;
        }
    }
}
