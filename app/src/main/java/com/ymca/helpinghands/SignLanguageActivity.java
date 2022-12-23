package com.ymca.helpinghands;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class SignLanguageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_language);
        WebView mywebview = (WebView) findViewById(R.id.webView_signlang);
        mywebview.setWebViewClient(new WebViewClient());
        mywebview.getSettings().setJavaScriptEnabled(true);
        mywebview.getSettings().setDomStorageEnabled(true);
        mywebview.setOverScrollMode(WebView.OVER_SCROLL_NEVER);
        mywebview.loadUrl("https://www.handspeak.com/word/search/index.php?id=2676");
    }
}