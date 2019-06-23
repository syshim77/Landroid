package com.example.mycustomview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.util.AttributeSet;
import android.view.View;

public class MyView extends View {

    Paint paint;
    Bitmap mBitmap;
    Canvas mCanvas;

    Context mContext;

    public MyView(Context context) {
        super(context);

        init(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    private void init(Context context) {
        paint = new Paint();
        paint.setAntiAlias(true);

        mContext = context;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        if (w>0 && h>0) {   // w=0,h=0일수도 있으므로 체크해줘야함
            mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
            mCanvas = new Canvas();
            mCanvas.setBitmap(mBitmap);

            draw1();
        }

        super.onSizeChanged(w, h, oldw, oldh);
    }

    private void draw1() {
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.RED);
        mCanvas.drawRect(100, 100, 200, 200, paint);

        paint.setStyle(Paint.Style.STROKE);
        //paint.setColor(Color.MAGENTA);
        paint.setARGB(128, 0, 255, 0);
        paint.setStrokeWidth(10.0f);
        mCanvas.drawRect(100, 100, 200, 200, paint);

        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLUE);

        DashPathEffect effect = new DashPathEffect(new float[]{5,5}, 1);
        paint.setPathEffect(effect);
        mCanvas.drawLine(100, 300, 500, 500, paint);

        //paint.setStyle(Paint.Style.FILL);

        ShapeDrawable drawable1 = new ShapeDrawable();
        RectShape shape1 = new RectShape();
        shape1.resize(200, 200);
        drawable1.setShape(shape1);
        drawable1.setBounds(300, 100, 500, 300);

        drawable1.draw(mCanvas);

        LinearGradient gradient1 = new LinearGradient(0, 0, 0, 200, Color.RED, Color.YELLOW, Shader.TileMode.CLAMP);
        paint.setShader(gradient1);
        //canvas.drawRect(100,100,200,200, paint);

        shape1.resize(300, 300);
        drawable1.setBounds(400, 300, 700, 600);

        drawable1.draw(mCanvas);


        Bitmap faceBitmap = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.face);
        mCanvas.drawBitmap(faceBitmap, 500, 500, paint);

        Matrix matrix1 = new Matrix();
        matrix1.setScale(1, -1);    // 세로방향으로 거꾸로 이미지를 변환시킴
        Bitmap faceBitmap2 = Bitmap.createBitmap(faceBitmap, 0, 0, faceBitmap.getWidth(), faceBitmap.getHeight(), matrix1, false);
        mCanvas.drawBitmap(faceBitmap2, 800, 200, paint);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (mBitmap != null) {
            canvas.drawBitmap(mBitmap, 0, 0, null);
        }

//        paint.setStyle(Paint.Style.FILL);
//        paint.setColor(Color.RED);
//        canvas.drawRect(100, 100, 200, 200, paint);
//
//        paint.setStyle(Paint.Style.STROKE);
//        //paint.setColor(Color.MAGENTA);
//        paint.setARGB(128, 0, 255, 0);
//        paint.setStrokeWidth(10.0f);
//        canvas.drawRect(100, 100, 200, 200, paint);
//
//        paint.setStyle(Paint.Style.STROKE);
//        paint.setColor(Color.BLUE);
//
//        DashPathEffect effect = new DashPathEffect(new float[]{5,5}, 1);
//        paint.setPathEffect(effect);
//        canvas.drawLine(100, 300, 500, 500, paint);
//
//        //paint.setStyle(Paint.Style.FILL);
//
//        ShapeDrawable drawable1 = new ShapeDrawable();
//        RectShape shape1 = new RectShape();
//        shape1.resize(200, 200);
//        drawable1.setShape(shape1);
//        drawable1.setBounds(300, 100, 500, 300);
//
//        drawable1.draw(canvas);
//
//        LinearGradient gradient1 = new LinearGradient(0, 0, 0, 200, Color.RED, Color.YELLOW, Shader.TileMode.CLAMP);
//        paint.setShader(gradient1);
//        //canvas.drawRect(100,100,200,200, paint);
//
//        shape1.resize(300, 300);
//        drawable1.setBounds(400, 300, 700, 600);
//
//        drawable1.draw(canvas);
    }
}
