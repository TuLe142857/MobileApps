package vn.edu.ptithcm.networkingandroid.model;

public class WeatherForecastModel {
    private String time;
    private String temperature;
    private String icon;
    private String windSpeed;
    public WeatherForecastModel(String time, String temperature, String icon, String windSpeed) {
        this.time = time;
        this.temperature = temperature;
        this.icon = icon;
        this.windSpeed = windSpeed;
    }
    WeatherForecastModel() {
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getIcon() {
        return icon;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getTime() {
        return time;
    }

    public String getWindSpeed() {
        return windSpeed;
    }
}
