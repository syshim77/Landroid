package org.androidtown.mywidget;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;

public class MultiCheckBox extends LinearLayout {

    public interface OnMultiChangeListener{
        public void onMultiChaged(boolean isFirstChecked, boolean isSecondChecked);

    }

    OnMultiChangeListener listener;

    public void setOnMultiChangeListener(OnMultiChangeListener lsnr){
        listener = lsnr;

    }

    CheckBox checkBox;
    CheckBox checkBox2;


    public MultiCheckBox(Context context) {
        super(context);
        init(context);
    }

    public MultiCheckBox(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.multi_checkbox, this, true);
        /*바로 붙여주는 걸 true*/

        checkBox = findViewById(R.id.checkBox);
        checkBox2 = findViewById(R.id.checkBox2);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(listener != null){
                    listener.onMultiChaged(isChecked, checkBox2.isChecked());
                }
            }
        });

        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(listener != null){
                    listener.onMultiChaged(checkBox.isChecked(), isChecked);
                }
            }
        });
    }
}
