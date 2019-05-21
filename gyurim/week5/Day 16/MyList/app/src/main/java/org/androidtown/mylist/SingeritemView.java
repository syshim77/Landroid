package org.androidtown.mylist;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SingeritemView extends LinearLayout {
    TextView nameTextView;
    TextView ageTextView;
    public SingeritemView(Context context) {
        super(context);
        init(context);
    }

    public SingeritemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.singer_item, this, true);
        /*R.id.singer_item은 오류, R.layout.singer_item 오류 해결 왜?*/

        nameTextView = findViewById(R.id.nameTextView);
        ageTextView = findViewById(R.id.ageTextView);
    }

    public void setName(String name){
        nameTextView.setText(name);
    }

    public void setAge(String age){
        ageTextView.setText(age);
    }
}
