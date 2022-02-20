// package _42.ajav_launcher.Simulator;
// import _42.ajav_launcher.*;

public class Simulator {
	public static void main(String[] args) {
		WeatherTower weatherTower = new WeatherTower();
		Coordinates f1Coordinates = new Coordinates(10, 10, 10);
		Coordinates f2Coordinates = new Coordinates(10, 10, 10);
		Coordinates f3Coordinates = new Coordinates(10, 10, 10);
		Coordinates f4Coordinates = new Coordinates(10, 10, 10);
		Flyable f1 = new Helicopter("h1", f1Coordinates);
		Flyable f2 = new Helicopter("h1", f2Coordinates);
		Flyable f3 = new Helicopter("h1", f3Coordinates);
		Flyable f4 = new Helicopter("h1", f4Coordinates);
		f1.registerTower(weatherTower);
		f2.registerTower(weatherTower);
		f3.registerTower(weatherTower);
		f4.registerTower(weatherTower);
		for (int i = 0; i < 10; i++) {
			weatherTower.changeWeather();
		}
	}
}
