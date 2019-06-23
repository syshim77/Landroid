package com.example.mycamera;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class MyImageView extends View {

    Context mContext;
    Bitmap mBitmap;
    Bitmap flower;
    Canvas mCanvas;
    Paint paint;
    Camera camera = new Camera();

    public MyImageView(Context context) {
        super(context);

        init(context);
    }

    public MyImageView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    private void init(Context context) {
        mContext = context;
        paint = new Paint();

        flower = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.flower);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        if (w>0 && h>0) {
            mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
            mCanvas = new Canvas();
            mCanvas.setBitmap(mBitmap);

//            mCanvas.drawColor(Color.WHITE);
//            mCanvas.drawBitmap(flower, 0, 0, paint);
            mCanvas.drawBitmap(flower, 0, 0, paint);

            camera.save();
            Matrix matrix = new Matrix();
            camera.rotateY(45.0f);
            camera.translate(0, 0, 300.0f); // -3000.0f
            camera.getMatrix(matrix);
            camera.restore();

            Bitmap rotatedFlower = Bitmap.createBitmap(flower, 0, 0, flower.getWidth(), flower.getHeight(), matrix, true);
            mCanvas.drawBitmap(rotatedFlower, 600, 300, paint);
        }

        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (mBitmap != null) {
            canvas.drawBitmap(mBitmap, 0, 0, null);
        }
    }
}
