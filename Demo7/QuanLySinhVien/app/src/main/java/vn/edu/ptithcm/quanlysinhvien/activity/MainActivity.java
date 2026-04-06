package vn.edu.ptithcm.quanlysinhvien.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import vn.edu.ptithcm.quanlysinhvien.R;

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


    public void onClick(View view){
        int id = view.getId();
        if (id == R.id.btnClass){
            startActivity(new Intent(MainActivity.this, DanhMucLopHocActivity.class));
        }else if (id == R.id.btnStudent){
            startActivity(new Intent(MainActivity.this, QuanLySinhVienActivity.class));
        }
    }
}