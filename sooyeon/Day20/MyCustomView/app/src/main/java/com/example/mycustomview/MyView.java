package com.example.mycustomview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.util.AttributeSet;
import android.view.View;

public class MyView extends View {

    Paint paint;

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
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.RED);
        canvas.drawRect(100, 100, 200, 200, paint);

        paint.setStyle(Paint.Style.STROKE);
        //paint.setColor(Color.MAGENTA);
        paint.setARGB(128, 0, 255, 0);
        paint.setStrokeWidth(10.0f);
        canvas.drawRect(100, 100, 200, 200, paint);

        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLUE);

        DashPathEffect effect = new DashPathEffect(new float[]{5,5}, 1);
        paint.setPathEffect(effect);
        canvas.drawLine(100, 300, 500, 500, paint);

        //paint.setStyle(Paint.Style.FILL);

        ShapeDrawable drawable1 = new ShapeDrawable();
        RectShape shape1 = new RectShape();
        shape1.resize(200, 200);
        drawable1.setShape(shape1);
        drawable1.setBounds(300, 100, 500, 300);

        drawable1.draw(canvas);

        LinearGradient gradient1 = new LinearGradient(0, 0, 0, 200, Color.RED, Color.YELLOW, Shader.TileMode.CLAMP);
        paint.setShader(gradient1);
        //canvas.drawRect(100,100,200,200, paint);

        shape1.resize(300, 300);
        drawable1.setBounds(400, 300, 700, 600);

        drawable1.draw(canvas);
    }
}
