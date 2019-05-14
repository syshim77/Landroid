package org.androidtown.mywebview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView) findViewById(R.id.webView); // webview 리턴
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
    }

    public void onButton1Clicked(View v){
        //webView.loadUrl("https://m.naver.com");
        webView.loadUrl("file://android_asset/sample.html");
    }
}
