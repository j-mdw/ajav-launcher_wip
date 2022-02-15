// package _42.ajav_launcher.UnknownWeatherException;

import java.lang.Exception;

public class UnknownWeatherException extends Exception {
    public UnknownWeatherException(String weather) {
        super("weather " + weather + " is unknown");
        System.out.println(weather);
    }
}
