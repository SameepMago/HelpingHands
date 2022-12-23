package com.ymca.helpinghands;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class DeafOrganisationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deaf_organisation);
        WebView mywebview = (WebView) findViewById(R.id.webView_deaforg);
        mywebview.loadUrl("https://www.wannathankyou.com/blog/10-ngos-for-the-hearing-impaired-you-should-know-of-on-this-world-deaf-day-100");

    }
}