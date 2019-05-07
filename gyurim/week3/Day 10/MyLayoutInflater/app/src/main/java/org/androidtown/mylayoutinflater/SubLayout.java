package org.androidtown.mylayoutinflater;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

public class SubLayout extends LinearLayout {
    public SubLayout(Context context) {
        super(context);

        init(context);
    }

    public SubLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }
//    뷰를 직접 상속해서 만들땐, 생성자 적어도 2개는 가져야한다.

    private void init(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.sub_layout, this, true);
//        오류 이유 : 부분 화면 때 프로젝트 안해서 그럼
    }

}
