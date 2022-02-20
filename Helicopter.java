public class Helicopter extends Aircraft implements Flyable {

	private boolean landed = false;
	private WeatherTower weatherTower = null;
	private static String[] weatherSentence = {
		"Oh no, it's raining again.",
		"Fog? You gotta be kidding..",
		"Let the sun shine!",
		"I love snow."
	};
	public Helicopter(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	public void updateConditions() throws UnknownWeatherException, NoWeatherTower {
		// System.out.println("Coordinates: " + coordinates.getLongitude() + " ; " + coordinates.getLatitude() + " ; " + coordinates.getHeight());
		if (weatherTower == null)
			throw new NoWeatherTower();
		
		String currentWeatherName = weatherTower.getWeather(coordinates);
		// System.out.println("Weather: " + currentWeatherName);
		WeatherType currentWeather = WeatherProvider.getProvider().toEnum(currentWeatherName);
		switch (currentWeather) {
			case RAIN:
				coordinates.move(5, 0, 0);
				break;
			case FOG:
				coordinates.move(1, 0, 0);
				break;
			case SUN:
				coordinates.move(10, 0, 2);
				break;
			case SNOW:
				coordinates.move(0, 0, -12);
				break;
			default:
				throw new UnknownWeatherException(currentWeatherName); 
		}
		String msg = "Helicopter#" + name + "(" + id + ")";
		if (coordinates.getHeight() <= 0) {
			msg += " landed.";
			Printer.getInstance().write(msg);
			this.landed = true;
			unregister();
		} else {
			msg += ": " + weatherSentence[currentWeather.ordinal()];
			Printer.getInstance().write(msg);
		}
	};

	public boolean hasLanded() {
		return this.landed;
	};

	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		weatherTower.register(this);
		Printer.getInstance().write("Tower says: Helicopter#" + name + '(' + id + ") registered to weather tower.");
	};

	private void unregister() {
		// weatherTower.unregister(this);
		Printer.getInstance().write("Tower says: Helicopter#" + name + '(' + id + ") unregistered from weather tower.");	
	}
}
