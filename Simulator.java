// package _42.ajav_launcher.Simulator;
// import _42.ajav_launcher.*;

public class Simulator {
	public static void main(String[] args) {
		WeatherTower weatherTower = new WeatherTower();
		Coordinates coordinates = new Coordinates(10, 10, 10);
		Flyable f1 = new Helicopter("h1", coordinates);
		f1.registerTower(weatherTower);
		for (int i = 0; i < 10; i++) {
			weatherTower.changeWeather();
		}
	}
}
