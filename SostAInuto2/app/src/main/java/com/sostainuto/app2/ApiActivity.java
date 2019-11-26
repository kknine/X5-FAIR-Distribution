package com.sostainuto.app2;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.webkit.WebView;

public class ApiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api);
        WebView myWebView = (WebView) findViewById(R.id.api_web);
        myWebView.loadUrl("https://platform.x5gon.org/search?text=energy+saving+lightbulbs&page=1&type=all");
    }

}
