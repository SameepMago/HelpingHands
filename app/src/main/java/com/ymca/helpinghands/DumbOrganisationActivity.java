package com.ymca.helpinghands;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class DumbOrganisationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dumb_organisation);
        WebView mywebview = (WebView) findViewById(R.id.webView_dumborg);
        mywebview.loadUrl("http://www.udaan.org/parivaar/orgdelhi.html");
    }
}