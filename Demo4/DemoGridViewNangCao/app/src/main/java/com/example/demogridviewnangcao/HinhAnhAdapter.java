package com.example.demogridviewnangcao;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.demogridviewnangcao.model.HinhAnh;

import java.util.List;

public class HinhAnhAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<HinhAnh> arr;

    public HinhAnhAdapter(Context context, int layout, List<HinhAnh> arr) {
        this.context = context;
        this.layout = layout;
        this.arr = arr;
    }


    @Override
    public int getCount() {
        return arr.size();
    }

    @Override
    public Object getItem(int position) {
        return arr.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(layout, parent, false);

        ImageView imageView = convertView.findViewById(R.id.imageView);
        HinhAnh hinhAnh = arr.get(position);

        imageView.setImageResource(hinhAnh.getHinh());
        return convertView;
    }
}
