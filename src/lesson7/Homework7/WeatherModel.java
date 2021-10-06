package lesson7.Homework7;


import java.io.IOException;
import java.sql.SQLException;


public interface WeatherModel {
    void getWeather(String selectedCity, Period period) throws IOException, SQLException;
}
