package org.androidtown.mywidget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MultiCheckBox multicheck = findViewById(R.id.multicheck);
        multicheck.setOnMultiChangeListener(new MultiCheckBox.OnMultiChangeListener() {
            @Override
            public void onMultiChaged(boolean isFirstChecked, boolean isSecondChecked) {
                Toast.makeText(getApplicationContext(), "첫번째 체크 : "+isFirstChecked+" 두번째 체크 : "+isSecondChecked, Toast.LENGTH_LONG).show();
            }
        });
    }
}
