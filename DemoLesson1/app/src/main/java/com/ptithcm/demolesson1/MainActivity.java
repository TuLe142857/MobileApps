package com.ptithcm.demolesson1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void demoEditText(View view) {
        Intent intent = new Intent(MainActivity.this, DemoEditTextActivity.class);
        startActivity(intent);
    }

    public void demoWebView(View view) {
        Intent intent = new Intent(MainActivity.this, DemoWebViewActivity.class);
        startActivity(intent);
    }

    public void demoToggleButton(View view) {
        Intent intent = new Intent(MainActivity.this, DemoToggleButtonActivity.class);
        startActivity(intent);
    }

    public void demoToast(View view) {
        Intent intent = new Intent(MainActivity.this, DemoToastActivity.class);
        startActivity(intent);
    }

    public void demoSeekBar(View view) {
        Intent intent = new Intent(MainActivity.this, DemoSeekBarActivity.class);
        startActivity(intent);
    }

    public void demoImageButton(View view) {
        Intent intent = new Intent(MainActivity.this, DemoImageButtonActivity.class);
        startActivity(intent);
    }
}