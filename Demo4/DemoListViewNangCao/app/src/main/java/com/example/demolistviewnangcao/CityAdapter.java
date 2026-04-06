package com.example.demolistviewnangcao;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CityAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<City> cityList;

    public CityAdapter(Context context, int layout, List<City> cityList) {
        this.context = context;
        this.layout = layout;
        this.cityList = cityList;
    }

    @Override
    public int getCount() {
        return cityList.size();
    }

    @Override
    public Object getItem(int position) {
        return cityList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate( layout,parent, false);
        ImageView imageView = convertView.findViewById(R.id.image);
        TextView cityNameTextView = convertView.findViewById(R.id.cityName);
        TextView wikiLinkTextView = convertView.findViewById(R.id.linkWiki);

        City city = cityList.get(position);
        imageView.setImageResource(city.getImage());
        cityNameTextView.setText(city.getName());
        wikiLinkTextView.setText(city.getLinkWiki());

        return convertView;
    }
}
