package com.example.demogridviewnangcao;

import android.os.Bundle;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.demogridviewnangcao.model.HinhAnh;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<HinhAnh> arr;
    GridView gridView;
    HinhAnhAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        gridView = findViewById(R.id.gridView);

        arr = new ArrayList<>();
        int[] images = {
                R.drawable.img1,
                R.drawable.img2,
                R.drawable.img3,
                R.drawable.img4,
                R.drawable.img5,
                R.drawable.img6,
                R.drawable.img7,
                R.drawable.img8,
                R.drawable.img9
        };
        for (int i = 0; i < images.length; i++) {
            arr.add(new HinhAnh(images[i], "Image " + (i + 1)));
        }

        adapter = new HinhAnhAdapter(MainActivity.this, R.layout.dong_hinh_anh, arr);
        gridView.setAdapter(adapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}