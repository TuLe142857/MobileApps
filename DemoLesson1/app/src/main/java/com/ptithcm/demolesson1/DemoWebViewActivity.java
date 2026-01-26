package com.ptithcm.demolesson1;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DemoWebViewActivity extends AppCompatActivity {
    EditText editText;
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_demo_web_view);

        editText = findViewById(R.id.editText);
        webView = findViewById(R.id.webView);

        webView.setWebViewClient(new WebViewClient());


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void onBack(View view) {
        if(webView.canGoBack()){
            webView.goBack();
        }
    }

    public void onForward(View view) {
        if(webView.canGoForward()){
            webView.goForward();
        }
    }

    public void onReload(View view) {
        webView.reload();
    }

    public void onGo(View view) {
        String url = editText.getText().toString();
        webView.loadUrl(url);
    }
}