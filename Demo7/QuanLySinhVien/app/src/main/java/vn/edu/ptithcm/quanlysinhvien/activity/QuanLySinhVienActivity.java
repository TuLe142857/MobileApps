package vn.edu.ptithcm.quanlysinhvien.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import vn.edu.ptithcm.quanlysinhvien.R;
import vn.edu.ptithcm.quanlysinhvien.adapter.LopHocAdapter;
import vn.edu.ptithcm.quanlysinhvien.adapter.SinhVienAdapter;
import vn.edu.ptithcm.quanlysinhvien.model.LopHoc;
import vn.edu.ptithcm.quanlysinhvien.model.SinhVien;
import vn.edu.ptithcm.quanlysinhvien.sqlite.SinhVienDAO;
import vn.edu.ptithcm.quanlysinhvien.sqlite.LopHocDAO;
import vn.edu.ptithcm.quanlysinhvien.helper.DateTimeHelper;

public class QuanLySinhVienActivity extends AppCompatActivity implements View.OnClickListener{
    EditText edtMaSV, edtHotenSV, edtNgaySinhSV;
    ListView lvDanhsachSinhvien;
    Spinner spLopHoc ;
    SinhVienAdapter sinhVienAdapter;
    private List<LopHoc> lopHocList;
    private List<SinhVien> sinhVienList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_sinhvien);
        findViewById(R.id.btnLuuSinhVien).setOnClickListener(this);
        findViewById(R.id.btnThoatSinhVien).setOnClickListener(this);
        edtMaSV = findViewById(R.id.edtMaSV);
        edtHotenSV = findViewById(R.id.edtHotenSV);
        edtNgaySinhSV = findViewById(R.id.edtNgaySinhSV);
        spLopHoc = findViewById(R.id.spLopHoc);
        fillLopHocToSpinner();
        lvDanhsachSinhvien = findViewById(R.id.lvDanhsachSinhvien);
        fillLopHocToListView();

        spLopHoc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                fillLopHocToListView();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    private void fillLopHocToListView() {
        SinhVienDAO sinhVienDAO = new SinhVienDAO(this);
        try {
            int lopHocid =lopHocList.get(spLopHoc.getSelectedItemPosition()).getId() ;
            sinhVienList = sinhVienDAO.getAllByLophoc(lopHocid);
            sinhVienAdapter = new SinhVienAdapter(this,sinhVienList);
            lvDanhsachSinhvien.setAdapter(sinhVienAdapter);
        } catch ( Exception ex )
        {
            ex.printStackTrace();
        }
    }

    private void fillLopHocToSpinner() {
        LopHocDAO lopHocDAO = new LopHocDAO(this);
        lopHocList = lopHocDAO.getAll();
        LopHocAdapter lopHocAdapter = new LopHocAdapter(this, lopHocList);
        spLopHoc.setAdapter(lopHocAdapter);
    }

    @Override
    public void onClick(View view) {
        SinhVienDAO sinhVienDAO = new SinhVienDAO(this);
        int id  = view.getId();

        if (id == R.id.btnLuuSinhVien){
            try {
                SinhVien sinhVien = new SinhVien();
                sinhVien.setId(edtMaSV.getText().toString());
                sinhVien.setHoten(edtHotenSV.getText().toString());
                sinhVien.setNgaysinh(DateTimeHelper.toDate(edtNgaySinhSV.getText().toString()) );

                int lopHoc = spLopHoc.getSelectedItemPosition();
                sinhVien.setLophocid(lopHocList.get(lopHoc).getId());
                Toast.makeText(this,"" + lopHocList.get(lopHoc).getId(),Toast.LENGTH_LONG).show();
                sinhVienDAO.insert(sinhVien);
                Toast.makeText(this,"Sinh viên đã được lưu",Toast.LENGTH_LONG).show();
                fillLopHocToListView();
            } catch ( Exception ex )
            {
                ex.printStackTrace();
            }
        }
        else if (id == R.id.btnThoatSinhVien){
            finish();
        }
    }
}
