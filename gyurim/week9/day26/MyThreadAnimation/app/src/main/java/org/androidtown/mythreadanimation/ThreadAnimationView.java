package org.androidtown.mythreadanimation;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ImageView;


public class ThreadAnimationView extends ImageView {
    int[] imageArray = {R.drawable.die, R.drawable.zzang, R.drawable.tent, R.drawable.energy};
    Handler handler = new Handler();

    public ThreadAnimationView(Context context) {
        super(context);

        init(context);
    }

    public ThreadAnimationView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    private void init(Context context){
        ImageThread thread = new ImageThread();
        thread.start();
    }

    class ImageThread extends Thread{
        boolean running = false;
        int index = 0;
        int interval = 800;

        public void run(){
            running = true;

            while(running){
                handler.post(new Runnable(){
                    public void run(){
                        //UI 직접 접근
                        setImageResource(imageArray[index]);
                        invalidate();
                    }
                });

                try{
                    Thread.sleep(interval);}
                catch(Exception e){
                    e.printStackTrace();
                }

                index++; // 이미지 변경하기 위함
                if(index>3){
                    index=0;
                }
            }
        }
    }
}

