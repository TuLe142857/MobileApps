package com.example.demoimageview;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textView;
    ImageView imageView;
    int[] buttonId = {R.id.button, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6, R.id.button7};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        imageView = findViewById(R.id.imageView);

        for (int id:buttonId){
            Button btn = findViewById(id);
            btn.setOnClickListener(MainActivity.this);
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.button){
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            textView.setText("Center");
        }
        if (id == R.id.button2){
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            textView.setText("Center Crop");
        }
        if (id == R.id.button3){
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            textView.setText("Center Inside");
        }
        if (id == R.id.button4){
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            textView.setText("Fit Center");
        }
        if (id == R.id.button5){
            imageView.setScaleType(ImageView.ScaleType.FIT_END);
            textView.setText("Fix End");
        }
        if (id == R.id.button6){
            imageView.setScaleType(ImageView.ScaleType.FIT_START);
            textView.setText("Fit Start");
        }if (id == R.id.button7){
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            textView.setText("Fix XY");
        }


    }
}