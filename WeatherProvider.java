// package _42.ajav_launcher.WeatherProvider;

// import _42.ajav_launcher.*;
import java.util.concurrent.ThreadLocalRandom;

public class WeatherProvider {
	private static WeatherProvider instance = null;
	private static String[] weatherOptions = {
		"rain",
		"fog",
		"sun",
		"snow"
	};

	private WeatherProvider() {}

	public static WeatherProvider getProvider() {
		if (instance == null)
			instance = new WeatherProvider();
		return instance;
	}

	public static String getCurrentWeather(Coordinates coordinates) {
		return weatherOptions[(
			coordinates.getLatitude() +
			coordinates.getLongitude() +
			coordinates.getHeight() +
			ThreadLocalRandom.current().nextInt(0, 5)
			) % 4];	
	}

	public WeatherType toEnum(String weather) throws UnknownWeatherException {
		for (int i = 0; i < weatherOptions.length; i++) {
			if (weatherOptions[i].compareTo(weather) == 0)
				return WeatherType.values()[i];
		}
		throw new UnknownWeatherException(weather);
	}
}
