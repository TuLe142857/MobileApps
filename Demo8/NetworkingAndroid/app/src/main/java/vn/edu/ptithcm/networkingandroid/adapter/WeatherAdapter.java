package vn.edu.ptithcm.networkingandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ptithcm.networkingandroid.R;
import vn.edu.ptithcm.networkingandroid.model.WeatherForecastModel;

public class WeatherAdapter extends BaseAdapter {
    private Context context;
    private List<WeatherForecastModel> weatherForecastModels = new ArrayList<>();

    public WeatherAdapter(Context context, List<WeatherForecastModel> weatherForecastModels) {
        this.context = context;
        this.weatherForecastModels = weatherForecastModels;
    }


    @Override
    public int getCount() {
        return weatherForecastModels.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, android.view.ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.layout_weather_items, null);
        }
        TextView time = convertView.findViewById(R.id.txtTimeForecast);
        TextView temperature = convertView.findViewById(R.id.txtTemperatureForecast);
        TextView windSpeed = convertView.findViewById(R.id.txtWindForecast);
        ImageView image = convertView.findViewById(R.id.imgForecast);

        WeatherForecastModel weatherForecastModel = weatherForecastModels.get(position);

        time.setText(" " + weatherForecastModel.getTime());
        temperature.setText(weatherForecastModel.getTemperature() + "°C");
        windSpeed.setText(weatherForecastModel.getWindSpeed() + "km");

        Picasso.get().load("https:" + weatherForecastModel.getIcon()).into(image);

        return convertView;
    }
}
