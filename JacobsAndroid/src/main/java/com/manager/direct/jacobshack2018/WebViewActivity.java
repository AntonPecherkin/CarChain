package com.manager.direct.jacobshack2018;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebViewActivity extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        webView = findViewById(R.id.web_view);
        webView.loadUrl("https://www.skyscanner.de/mietwagen/ergebnisse/128668286/128668286/2018-11-09T10:00/2018-11-16T10:00/30");

    }
}
