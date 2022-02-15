// package _42.ajav_launcher.Flyable;

// import _42.ajav_launcher.*;

interface Flyable {
	public void updateConditions() throws UnknownWeatherException, NoWeatherTower;
	public void registerTower(WeatherTower weatherTower);
}
