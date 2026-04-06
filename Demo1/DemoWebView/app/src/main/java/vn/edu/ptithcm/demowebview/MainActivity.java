package vn.edu.ptithcm.demowebview;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        webView = findViewById(R.id.webView);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webView.setWebViewClient(new WebViewClient());



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    public void onBack(View view){
        if (webView.canGoBack())
            webView.goBack();
        else
            Toast.makeText(MainActivity.this, "Can not go back", Toast.LENGTH_SHORT).show();
    }

    public void onForward(View view){
        if (webView.canGoForward())
            webView.goForward();
        else
            Toast.makeText(this, "Can not go forward", Toast.LENGTH_SHORT).show();
    }

    public void onReload(View view){
        webView.reload();
    }


    public void onGo(View view){
        String url = editText.getText().toString();
        if (!url.startsWith("https"))
            url = "https://" + url;
        webView.loadUrl(url);
    }
}