package org.androidtown.mycustomview;

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

        init(context); // 초기화
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context); // 초기화
    }

    private void init(Context context){
        paint = new Paint();
        paint.setAntiAlias(true);

        mContext = context;

    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        if (w>0&&h>0){
            mBitmap = Bitmap.createBitmap(w,h,Bitmap.Config.ARGB_8888);
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

        paint.setStyle(Paint.Style.STROKE); /*선 만*/
        paint.setColor(Color.MAGENTA);
        /* paint.setARGB(128,0,255,0);*/ /*반투명*/
        paint.setStrokeWidth(10.0f);
        mCanvas.drawRect(100, 100, 200, 200, paint);

        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLUE);

        DashPathEffect effect = new DashPathEffect(new float[]{5,5}, 1);
        paint.setPathEffect(effect);
        mCanvas.drawLine(100, 300, 500, 500, paint);

        /*그리기 객체*/
        ShapeDrawable drawable = new ShapeDrawable();
        RectShape shape1 = new RectShape();
        shape1.resize(200, 200);
        drawable.setShape(shape1);
        drawable.setBounds(300, 100, 500, 300); /*끝나는 점의 x와 y 좌표 : right, bottom*/

        drawable.draw(mCanvas);

        LinearGradient gradient1 = new LinearGradient(0, 0, 0, 300, Color.BLACK, Color.YELLOW, Shader.TileMode.CLAMP);
        paint.setShader(gradient1);

        shape1.resize(300, 300);
        drawable.setBounds(400, 300, 700, 600);
        drawable.draw(mCanvas);

        /*비트맵 객체 만드는 방법 -> BitmapFactory*/
        Bitmap faceBitmap = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.face);
        mCanvas.drawBitmap(faceBitmap, 500, 500, paint);


        Matrix matrix1 = new Matrix();
        matrix1.setScale(1, -1); /*(1,-1) : 세로 방향으로 거꾸로 ! 확대,축소*/
        Bitmap faceBitmap2 = Bitmap.createBitmap(faceBitmap, 0, 0, faceBitmap.getWidth(), faceBitmap.getHeight(), matrix1, false);
        mCanvas.drawBitmap(faceBitmap2, 800, 200, paint);


    }


    /*더블 버퍼링*/
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if(mBitmap != null){
            canvas.drawBitmap(mBitmap, 0, 0, null);
        }
    }
}
