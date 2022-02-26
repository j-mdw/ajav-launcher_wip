// package ajav_launcher;

import java.io.FileNotFoundException;

public class Simulator {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Wrong number of arguments");
			return ;
		}
		WeatherTower weatherTower = new WeatherTower();
		Parser parser = new Parser();
		SimulationInputs simInputs;
		try {
			simInputs = parser.parseSimulation(args[0]);
		} catch (FileNotFoundException err) {
			System.out.println("Could not find input file: " + args[0]);
			return ;
		} catch (Exception err) {
			System.out.println(err.getMessage());
			return ;
		}
		for (Flyable flyable: simInputs.flyables) {
			flyable.registerTower(weatherTower);
		}
		for (int i = 0; i < simInputs.repetitions; i++) {
			weatherTower.changeWeather();
		}
	}
}
