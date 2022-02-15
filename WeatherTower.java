// package _42.ajav_launcher.WeatherTower;

// import _42.ajav_launcher.*;

public class WeatherTower extends Tower {
	public String getWeather(Coordinates coordinates) { 
		return WeatherProvider.getProvider().getCurrentWeather(coordinates);
	}
	public void changeWeather() {
		conditionsChanged();
	}
}
