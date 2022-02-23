public class Baloon extends Aircraft implements Flyable {

	private boolean landed = false;
	private WeatherTower weatherTower = null;
	private static String[] weatherSentence = {
		"Why do I have a baloon again?",
		"Seriously this makes no sense",
		"Well I have a baloon...",
		"Can we just land and be done with this?"
	};
	public Baloon(String name, Coordinates coordinates) {
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
				coordinates.move(0, 0, -5);
				break;
			case FOG:
				coordinates.move(0, 0, -3);
				break;
			case SUN:
				coordinates.move(2, 0, 4);
				break;
			case SNOW:
				coordinates.move(0, 0, -15);
				break;
			default:
				throw new UnknownWeatherException(currentWeatherName); 
		}
		String msg = "Baloon#" + name + "(" + id + ")";
		if (coordinates.getHeight() <= 0) {
			msg += " landed: longitude " + coordinates.getLongitude() + "; latitude " + coordinates.getLatitude();
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
		Printer.getInstance().write("Tower says: Baloon#" + name + '(' + id + ") registered to weather tower.");
	};

	private void unregister() {
		// weatherTower.unregister(this);
		Printer.getInstance().write("Tower says: Baloon#" + name + '(' + id + ") unregistered from weather tower.");	
	}
}
