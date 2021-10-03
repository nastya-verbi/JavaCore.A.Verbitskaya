package lesson6.Homework6;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class AccuWeather {
    public static void main(String[] args) throws IOException {

        OkHttpClient okHttpClient = new OkHttpClient();

        Request request = new Request.Builder()
        .url("https://api.openweathermap.org/data/2.5/weather?q=London,uk&APPID=2711916c445d123957f963e549eb8e9b")
        .build();

        Response response = okHttpClient.newCall(request).execute();
        System.out.println(response.body().string());

    }
}
