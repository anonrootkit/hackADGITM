package com.hackathon.adgitm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class Web_Activity extends AppCompatActivity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_);
        Bundle bundle = getIntent().getExtras();
        String url = bundle.getString("url");
        webView=findViewById(R.id.webview);
        webView.loadUrl(url);
    }
}
