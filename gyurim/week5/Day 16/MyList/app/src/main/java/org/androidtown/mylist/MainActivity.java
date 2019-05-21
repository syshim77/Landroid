package org.androidtown.mylist;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    SingerAdapter adapter;

    String[] names = {"소녀시대", "트와이스", "블랙핑크", "Billy"};
    String[] ages = {"20", "21", "22", "19"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.singer_item);
        adapter = new SingerAdapter();

        adapter.addItem(new SingerItem(names[0], ages[0]));
        adapter.addItem(new SingerItem(names[1], ages[1]));
        adapter.addItem(new SingerItem(names[2], ages[2]));
        adapter.addItem(new SingerItem(names[3], ages[3]));

        listView.setAdapter(adapter);
    }

    class SingerAdapter extends BaseAdapter{
        ArrayList<SingerItem> items = new ArrayList<>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(SingerItem item){
            items.add(item);
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            /*
            TextView view = new TextView(getApplicationContext());
            view.setText(names[position]);
            view.setTextSize(50.0f);
           view.setTextColor(Color.BLACK);*/

            SingeritemView view = null;
            if(convertView == null){
                view = new SingeritemView(getApplicationContext());
            } else {
                view = (SingeritemView) convertView;
            }



            SingerItem curItem = items.get(position);


            view.setName(curItem.getName());
            view.setAge(curItem.getAge());
            return view;
        }
    }
}
