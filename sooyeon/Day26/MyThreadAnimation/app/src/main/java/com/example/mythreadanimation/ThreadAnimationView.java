package com.example.mythreadanimation;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class ThreadAnimationView extends ImageView {

    int[] imageArray = {R.drawable.emoticon1, R.drawable.emoticon2, R.drawable.emoticon3, R.drawable.emoticon4};

    //Handler handler = new Handler();

    public ThreadAnimationView(Context context) {
        super(context);

        init(context);
    }

    public ThreadAnimationView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    private void init(Context context) {
        ImageThread thread = new ImageThread();
        thread.start();

        this.setImageResource(R.drawable.emoticon1);
    }

    class ImageThread extends Thread {
        boolean running = false;
        int index = 0;
        int interval = 800;

        public void run() {
            running = true;

            while(running) {
                //handler.post(new Runnable() {
                    //public void run() {
                        setImageResource(imageArray[index]);
                        invalidate();
                    //}
                //});

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
    }
}
