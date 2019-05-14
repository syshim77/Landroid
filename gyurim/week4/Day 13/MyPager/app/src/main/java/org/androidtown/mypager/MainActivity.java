package org.androidtown.mypager;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ViewPager pager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager =findViewById(R.id.pager);
        MyAdapter adapter = new MyAdapter();
        pager.setAdapter(adapter);
    }

    public void onButton1Clicked(View v){
        pager.setCurrentItem(1);
       /* 0:1번째 화면, 1:2번째 화면, 2:3번째 화면*/

    }

    class MyAdapter extends PagerAdapter{
        String[] names={"규림", "귤임", "박귤"};
        @Override
        public int getCount() {
            return names.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return view.equals(o);
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            LinearLayout layout = new LinearLayout(getApplicationContext());
            layout.setOrientation(LinearLayout.VERTICAL);

            TextView view = new TextView(getApplicationContext());
            view.setText(names[position]);
            view.setTextSize(40.0f);

            layout.addView(view);
            /*layout 안에 textview가 태그로 들어가는 것과 같은 효과*/
            container.addView(layout);

            return layout;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View) object);
        }
    }
}
