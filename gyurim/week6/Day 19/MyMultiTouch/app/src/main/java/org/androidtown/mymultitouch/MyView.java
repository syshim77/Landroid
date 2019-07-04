package org.androidtown.mymultitouch;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class MyView extends View {
    private static final String TAG = "MyView";
    Paint paint;

    float diffX1;
    float diffY1;

    float curX1;
    float curY1;
    float curX2;
    float curY2;

    float oldX1;
    float oldY1;
    float oldX2;
    float oldY2;

    Bitmap bitmap;
    Canvas mCanvas;
    Bitmap mBitmap;

    public MyView(Context context) {
        super(context);

        init(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    private void init(Context context){
        paint = new Paint();

        Resources res = context.getResources();
        bitmap = BitmapFactory.decodeResource(res,R.drawable.capture);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        if(w > 0 && h > 0){
            newImage(w, h);
            redraw();
        }
    }

    private void newImage(int w, int h){
        mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas();
        mCanvas.setBitmap(mBitmap);

    }

    private void redraw(){
        mCanvas.drawColor(Color.WHITE);
        mCanvas.drawBitmap(bitmap, diffX1, diffY1, paint);

        invalidate();
    }

    @Override
    public void onDraw(Canvas canvas) {
        if(mBitmap != null){
            canvas.drawBitmap(mBitmap,0, 0, null);
        }
    }

    /*더블버퍼링 기법*/

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        int pointerCount = event.getPointerCount();

        curX1 = event.getX(0);
        curY1 = event.getY(0);

        if(pointerCount >1) {
            curX2 = event.getX(1);
            curY2 = event.getY(1);
        }
        if(action == MotionEvent.ACTION_DOWN){
            /*손가락이 눌렸을때*/
            Log.d(TAG,"손가락이 눌렸습니다. : "+pointerCount +", "+curX1+","+curY1 +", "+curX2+", "+curY2);

        }else if (action == MotionEvent.ACTION_MOVE){
            Log.d(TAG,"손가락이 움직였습니다. : "+pointerCount +", "+curX1+","+curY1 +", "+curX2+", "+curY2);

            diffX1 = curX1;
            diffY1 = curY1;

            redraw();

        }else if(action==MotionEvent.ACTION_UP){
            /*손가락이 떼였을때*/
            Log.d(TAG,"손가락이 떼졌습니다. : "+pointerCount +", "+curX1+","+curY1 +", "+curX2+", "+curY2);
        }

        oldX1 = curX1;
        oldY1 = curY1;
        oldX2 = curX2;
        oldY2 = curY2;

        return true;
    }
}
