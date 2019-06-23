package com.example.mysurface;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Toast;

public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    SurfaceHolder holder;
    Paint paint;
    Context mContext;

    public MySurfaceView(Context context) {
        super(context);

        init(context);
    }

    public MySurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    private void init(Context context) {
        holder = getHolder();

        this.holder = getHolder();
        this.holder.addCallback(this);

        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(10.0f);
    }

    public void doDraw() {
//        Canvas canvas = holder.lockCanvas();
//        canvas.drawRect(100, 100, 200, 200, paint);
//        holder.unlockCanvasAndPost(canvas);
        Toast.makeText(mContext, "doDraw() 호출됨", Toast.LENGTH_LONG).show();

        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Toast.makeText(mContext, "onDraw() 호출됨", Toast.LENGTH_LONG).show();
        canvas.drawRect(100, 100, 200, 200, paint);
    }

    // 서피스뷰에 대한 상태 메소드 3개
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Toast.makeText(mContext, "surfaceCreated() 호출됨", Toast.LENGTH_LONG).show();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        Toast.makeText(mContext, "surfaceChanged() 호출됨", Toast.LENGTH_LONG).show();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        Toast.makeText(mContext, "surfaceDestroyed() 호출됨", Toast.LENGTH_LONG).show();
    }
}
