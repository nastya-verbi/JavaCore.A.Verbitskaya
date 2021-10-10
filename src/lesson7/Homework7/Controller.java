package lesson7.Homework7;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Controller {
    private WeatherModel weatherModel = new AccuWeatherModel();
    private Map<Integer, Period> variants = new HashMap<>();

    public Controller() {
        variants.put(1, Period.NOW);
        variants.put(2, Period.FIVE_DAYS);
        variants.put(3, Period.DB_PATH);
        variants.put(4, Period.DB_PATH_FIVE_DAYS);
    }

    public void getWeather(String userInput, String selectedCity) throws IOException, SQLException {
        Integer userIntegerInput = Integer.parseInt(userInput);

        switch (variants.get(userIntegerInput)) {
            case NOW:
                weatherModel.getWeather(selectedCity, Period.NOW);
                break;
            case FIVE_DAYS:
                weatherModel.getWeather(selectedCity, Period.FIVE_DAYS);
                break;
            case DB_PATH:
                weatherModel.getSavedToDBWeather();
                break;
            case DB_PATH_FIVE_DAYS:
                weatherModel.getSavedToDBWeathers5Days();
                break;
        }
    }
}
