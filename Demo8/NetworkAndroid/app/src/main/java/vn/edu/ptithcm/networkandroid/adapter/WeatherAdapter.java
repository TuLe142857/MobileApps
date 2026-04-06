package vn.edu.ptithcm.networkandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ptithcm.networkandroid.R;
import vn.edu.ptithcm.networkandroid.model.WeatherForecastModel;

public class WeatherAdapter extends BaseAdapter {
    private Context context;
    private List<WeatherForecastModel> arr;


    public WeatherAdapter(Context context, List<WeatherForecastModel> arr) {
        this.context = context;
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
        if (convertView == null){
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.layout_weather_items, parent);
        }
        WeatherForecastModel model = (WeatherForecastModel) this.getItem(position);
        TextView txtTime = convertView.findViewById(R.id.txtTimeForecast);
        TextView txtTemp = convertView.findViewById(R.id.txtTemperatureForecast);
        TextView txtWindSpeed = convertView.findViewById(R.id.txtWindForecast);
        ImageView imgView = convertView.findViewById(R.id.imgForecast);

        txtTime.setText(model.getTime());
        txtTemp.setText(model.getTemperature());
        txtWindSpeed.setText(model.getWindSpeed());
        Picasso.get().load("https:" + model.getIcon()).into(imgView);
        return convertView;
    }
}
