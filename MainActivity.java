package com.example.jamesyburr.browserandroid;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button backButton;
    Button forwardButton;
    EditText addressBar;
    Button goButton;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        backButton = (Button) findViewById(R.id.back);
        forwardButton = (Button) findViewById(R.id.forward);
        addressBar = (EditText) findViewById(R.id.addressBar);
        goButton = (Button) findViewById(R.id.go);
        webView = (WebView) findViewById(R.id.webView);

        backButton.setOnClickListener(this);
        forwardButton.setOnClickListener(this);
        goButton.setOnClickListener(this);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
               addressBar.setText(url);

            }
        });

    }

    @Override
    public void onClick(View v) {
        if (v == backButton) {
            webView.goBack();
        }
        else if (v == forwardButton) {
            webView.goForward();
        }
        else if (v == goButton){
            String url = addressBar.getText().toString();
            if (!url.startsWith("http")) {
                url = "http://" + url;
            }
            webView.loadUrl(url);
        }

    }
}
