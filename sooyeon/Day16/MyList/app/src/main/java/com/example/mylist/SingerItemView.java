package com.example.mylist;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SingerItemView extends LinearLayout {
    TextView nameTextView;
    TextView ageTextView;

    public SingerItemView(Context context) {
        super(context);

        init(context);
    }

    public SingerItemView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.singer_item, this, true);

        nameTextView = (TextView)findViewById(R.id.nameTextView);
        ageTextView = (TextView)findViewById(R.id.ageTextView);

    }

    public void setName(String name) {
        nameTextView.setText(name);
    }

    public void setAge(String age) {
        ageTextView.setText(age);
    }
}
