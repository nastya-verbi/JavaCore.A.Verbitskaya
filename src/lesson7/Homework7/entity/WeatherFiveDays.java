package lesson7.Homework7.entity;

public class WeatherFiveDays {
    private String city;
    private String localDate;
    private String weatherTextDay;
    private String weatherTextNight;
    double minTemperature;
    double maxTemperature;

    public WeatherFiveDays(String city, String localDate, String weatherTextDay, String weatherTextNight,
                           double minTemperature, double maxTemperature) {
        this.city = city;
        this.localDate = localDate;
        this.weatherTextDay = weatherTextDay;
        this.weatherTextNight = weatherTextNight;
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLocalDate() {
        return localDate;
    }

    public void setLocalDate(String localDate) {
        this.localDate = localDate;
    }

    public String getWeatherTextDay() {
        return weatherTextDay;
    }

    public void setWeatherTextDay(String weatherTextDay) {
        this.weatherTextDay = weatherTextDay;
    }

    public String getWeatherTextNight() {
        return weatherTextNight;
    }

    public void setWeatherTextNight(String weatherTextNight) {
        this.weatherTextNight = weatherTextNight;
    }

    public double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }
}
