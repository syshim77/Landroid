package org.androidtown.myintent;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent intent = getIntent();
        if(intent != null ){
            String title = intent.getStringExtra("title");
            int age = intent.getIntExtra("age", 0);
            Person person01 = (Person) intent.getSerializableExtra("person");

            Toast.makeText(getApplicationContext(), "Title: "+title, Toast.LENGTH_LONG).show();
            Toast.makeText(getApplicationContext(),"Person name : "+ person01.getName(),Toast.LENGTH_LONG).show();
        }

//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//           }
//        });
    }

}
