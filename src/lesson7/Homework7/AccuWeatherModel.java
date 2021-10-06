package lesson7.Homework7;

import com.fasterxml.jackson.databind.ObjectMapper;
import lesson7.Homework7.entity.WeatherFiveDays;
import lesson7.Homework7.entity.Weather;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.sql.SQLException;


import static java.lang.Math.round;

public class AccuWeatherModel implements WeatherModel {
    //http://dataservice.accuweather.com/forecasts/v1/daily/1day/349727
    private static final String PROTOKOL = "https";
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECASTS = "forecasts";
    private static final String VERSION = "v1";
    private static final String DAILY = "daily";
    private static final String ONE_DAY = "1day";
    private static final String FIVE_DAYS = "5day";
    private static final String API_KEY = "jvL0cuRpl9aT0ALn8P1R3koTsiec0Ype";
    private static final String API_KEY_QUERY_PARAM = "apikey";
    private static final String LOCATIONS = "locations";
    private static final String CITIES = "cities";
    private static final String AUTOCOMPLETE = "autocomplete";

    private static final OkHttpClient okHttpClient = new OkHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    private final DataBaseRepository dataBaseRepository = new DataBaseRepository();

    public void getWeather(String selectedCity, Period period) throws IOException, SQLException {
        switch (period) {
            case NOW: {
                HttpUrl httpUrl = new HttpUrl.Builder()
                        .scheme(PROTOKOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(ONE_DAY)
                        .addPathSegment(detectCityKey(selectedCity))
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .build();

                Request request = new Request.Builder()
                        .url(httpUrl)
                        .build();

                Response oneDayForecastResponse = okHttpClient.newCall(request).execute();
                String weatherResponse = oneDayForecastResponse.body().string();
                String localDate = objectMapper.readTree(weatherResponse)
                        .at("/DailyForecasts")
                        .get(0).at("/Date")
                        .asText();

                double temperature = objectMapper.readTree(weatherResponse).at("/DailyForecasts")
                        .get(0)
                        .at("/Temperature/Maximum/Value")
                        .asDouble();

                temperature = round((temperature - 32.0) * 5.0 / 9.0 * 100.0) / 100.0;
                System.out.println("В городе " + selectedCity + " на дату " + localDate.split("T")[0] +
                        " ожидается температура воздуха " + temperature + " C");

                Weather weather = new Weather(selectedCity, localDate.split("T")[0], temperature);
                DataBaseRepository dataBaseRepository = new DataBaseRepository();
                dataBaseRepository.saveWeatherToDataBase(weather);
            }
            break;

            case FIVE_DAYS: {
                HttpUrl httpUrl5Days = new HttpUrl.Builder()
                        .scheme(PROTOKOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(FIVE_DAYS)
                        .addPathSegment(detectCityKey(selectedCity))
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .build();

                Request request5Days = new Request.Builder()
                        .url(httpUrl5Days)
                        .build();

                Response fiveDayForecastResponse = okHttpClient.newCall(request5Days).execute();
                String weatherResponse5Days = fiveDayForecastResponse.body().string();

                int numberOfElements = objectMapper.readTree(weatherResponse5Days).at("/DailyForecasts").size();
                for (int i = 0; i < numberOfElements; i++) {
                    String localDate = objectMapper.readTree(weatherResponse5Days)
                            .at("/DailyForecasts")
                            .get(i)
                            .at("/Date")
                            .asText();
                    String weatherTextDay = objectMapper.readTree(weatherResponse5Days)
                            .at("/DailyForecasts")
                            .get(i)
                            .at("/Day/IconPhrase")
                            .asText();
                    String weatherTextNight = objectMapper.readTree(weatherResponse5Days)
                            .at("/DailyForecasts")
                            .get(i)
                            .at("/Night/IconPhrase")
                            .asText();
                    double minTemperature = objectMapper.readTree(weatherResponse5Days)
                            .at("/DailyForecasts")
                            .get(i)
                            .at("/Temperature/Minimum/Value")
                            .asDouble();
                    double maxTemperature = objectMapper.readTree(weatherResponse5Days)
                            .at("/DailyForecasts")
                            .get(i)
                            .at("/Temperature/Maximum/Value")
                            .asDouble();

                    minTemperature = round((minTemperature - 32.0) * 5.0 / 9.0 * 100.0) / 100.0;
                    maxTemperature = round((maxTemperature - 32.0) * 5.0 / 9.0 * 100.0) / 100.0;
                    System.out.println("В городе " + selectedCity + " на дату " + localDate.split("T")[0] + " " +
                            weatherTextDay + ", температура воздуха днем " + maxTemperature + " C. Ночью "
                            + weatherTextNight + ", температура воздуха " + minTemperature + " C.");

                    WeatherFiveDays weather5days = new WeatherFiveDays(selectedCity, localDate.split("T")[0],
                            weatherTextDay, weatherTextNight, minTemperature, maxTemperature);
                    DataBaseRepository dataBaseRepository = new DataBaseRepository();
                    dataBaseRepository.saveWeatherToDataBase5Days(weather5days);
                }
            }
            break;
        }
    }

    @Override
    public void getSavedToDBWeather() {
        dataBaseRepository.getSavedToDBWeather();
    }

    @Override
    public void getSavedToDBWeathers5Days() {
        dataBaseRepository.getSavedToDBWeathers5Days();
    }


    private String detectCityKey(String selectCity) throws IOException {
        //http://dataservice.accuweather.com/locations/v1/cities/autocomplete
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(PROTOKOL)
                .host(BASE_HOST)
                .addPathSegment(LOCATIONS)
                .addPathSegment(VERSION)
                .addPathSegment(CITIES)
                .addPathSegment(AUTOCOMPLETE)
                .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                .addQueryParameter("q", selectCity)
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .get()
                .addHeader("accept", "application/json")
                .build();

        Response response = okHttpClient.newCall(request).execute();
        String responseString = response.body().string();

        String cityKey = objectMapper.readTree(responseString)
                .get(0)
                .at("/Key")
                .asText();
        return cityKey;
    }
}
