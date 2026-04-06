package vn.edu.ptithcm.quanlysinhvien.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import vn.edu.ptithcm.quanlysinhvien.R;
import vn.edu.ptithcm.quanlysinhvien.model.LopHoc;

public class LopHocAdapter extends BaseAdapter {

    private Context context;
    private List<LopHoc> lopHocList;
    public LopHocAdapter(Context context, List<LopHoc> lopHocList) {
        this.context = context;
        this.lopHocList = lopHocList;
    }

    @Override
    public int getCount() {
        return lopHocList.size();
    }

    @Override
    public Object getItem(int position) {
        return lopHocList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.layout_danh_muc_lop_hoc_items,null);
        }
        TextView txtIdLopHoc = view.findViewById(R.id.txtIdLopHoc);
        TextView txtTenLopHoc = view.findViewById(R.id.txtTenLopHoc);
        LopHoc lopHoc = lopHocList.get(position);
        txtIdLopHoc.setText("" + lopHoc.getId());
        txtTenLopHoc.setText(lopHoc.getTenlophoc());
        return view;
    }
}
