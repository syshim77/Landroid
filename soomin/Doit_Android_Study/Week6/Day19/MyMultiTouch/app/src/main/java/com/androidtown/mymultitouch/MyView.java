package com.androidtown.mymultitouch;

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
    float curX1;
    float curY1;
    float curX2;
    float curY2;
    Bitmap bitmap;
    Bitmap mBitmap;
    Canvas mCanvas;
    Paint paint;

    // 이전 좌표를 가지고 있음
    float oldX1;
    float oldY1;
    float oldX2;
    float oldY2;

    float diffx1;
    float diffy1;

    public MyView(Context context) {
        super(context);
        init(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    // 비트맵 객체를 만듦
    private void init(Context context){
        paint = new Paint();
        Resources res = context.getResources();
        bitmap = BitmapFactory.decodeResource(res, R.drawable.arrow_left_clicked); // 비트맵 이미지 만듦

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        if (w > 0 && h > 0){
            newImage(w,h);
            redraw();
        }
    }

    // 사진 이미지가 아님
    private void newImage(int w, int h){
        // 비트맵 객체를 메모리에 올리는 것
        mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        // 그리기
        mCanvas = new Canvas();
        mCanvas.setBitmap(mBitmap);

    }

    // 사진 이미지를 그림
    private void redraw(){
        mCanvas.drawColor(Color.WHITE);

        // 차이값이 증가하면 그 차이값이 있는 곳으로 움직임
        mCanvas.drawBitmap(bitmap, diffx1,diffy1, paint);
    }

    // 이미지를 화면에 보여지기 위해서 뿌림
    @Override
    protected void onDraw(Canvas canvas) {
        // 화면에 그래픽이 그려지는 단계
        if(mBitmap != null){
            canvas.drawBitmap(mBitmap, 0,0, null);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        int pointerCount = event.getPointerCount();
        curX1 = event.getX(0);
        curY1 = event.getY(0);
        if (pointerCount > 1) {
            curX2 = event.getX(1);
            curY2 = event.getY(1);
        }
        if(action == MotionEvent.ACTION_DOWN){
            Log.d(TAG, "손가락이 눌렸습니다.: " + pointerCount + ", " + curX1 + ", " + curY1 + ", " + curX2 + ", " + curY2);

        } else  if(action == MotionEvent.ACTION_MOVE){
            Log.d(TAG, "손가락이 움직였습니다.: " + pointerCount + ", " + curX1 + ", " + curY1 + ", " + curX2 + ", " + curY2);

            diffx1 = curX1;// - oldX1;
            diffy1 = curY1;// - oldY1;

            // invalidate(); // ondraw가 호출되어 메모리에 있는 이미지를 다시 화면에 뿌려줌
            redraw();
        } else  if(action == MotionEvent.ACTION_UP){
            Log.d(TAG, "손가락이 떼졌습니다.: " + pointerCount + ", " + curX1 + ", " + curY1 + ", " + curX2 + ", " + curY2);
        }
        oldX1 = curX1;
        oldX2 = curX2;
        oldY1 = oldY1;
        oldY2 = oldY2;
        return true;
    }
}
