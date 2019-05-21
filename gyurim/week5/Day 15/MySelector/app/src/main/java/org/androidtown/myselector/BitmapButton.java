package org.androidtown.myselector;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;

public class BitmapButton extends android.support.v7.widget.AppCompatButton  {
    public BitmapButton(Context context) {
        super(context);

        init();
    }

    public BitmapButton(Context context, AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    private void init() {
        /*버튼이 만들어질 때 설정*/
        super.setBackgroundResource(R.drawable.button_01);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();

        if(action == MotionEvent.ACTION_DOWN){
            super.setBackgroundResource(R.drawable.button_02);
        } else if(action==MotionEvent.ACTION_UP){
            super.setBackgroundResource(R.drawable.button_01);
        }
        return true;
    }
}
