package vn.edu.ptithcm.quanlysinhvien.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import vn.edu.ptithcm.quanlysinhvien.R;
import vn.edu.ptithcm.quanlysinhvien.helper.DateTimeHelper;
import vn.edu.ptithcm.quanlysinhvien.model.SinhVien;

public class SinhVienAdapter extends BaseAdapter {
    private Context context;
    private List<SinhVien> sinhVienList;
    public SinhVienAdapter(Context context, List<SinhVien> sinhVienList) {
        this.context = context;
        this.sinhVienList = sinhVienList;
    }
    @Override
    public int getCount() {
        return sinhVienList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.layout_sinhvien_items,null);
        }
        TextView tvID = view.findViewById(R.id.tvID);
        TextView tvHoten = view.findViewById(R.id.tvHoten);
        TextView tvNgaysinh = view.findViewById(R.id.tvNgaysinh);
        SinhVien sinhVien = sinhVienList.get(position);
        tvID.setText(sinhVien.getId().toString());
        tvHoten.setText(sinhVien.getHoten().toString());
        tvNgaysinh.setText(DateTimeHelper.toString(sinhVien.getNgaysinh()) );
        return view;
    }
}
