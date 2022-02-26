// package ajav_launcher;

public class JetPlane extends Aircraft implements Flyable {

	private boolean landed = false;
	private WeatherTower weatherTower = null;
	private static String[] weatherSentence = {
		"It's raining, and I have a Jet!.",
		"Fog? No problem, cos I gotta a Jet!",
		"Life is perfect",
		"Snow? Not a problem if you got a JET"
	};
	public JetPlane(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	public void updateConditions() throws UnknownWeatherException, NoWeatherTower {
		if (weatherTower == null)
			throw new NoWeatherTower();
		
		String currentWeatherName = weatherTower.getWeather(coordinates);
		WeatherType currentWeather = WeatherProvider.getProvider().toEnum(currentWeatherName);
		switch (currentWeather) {
			case RAIN:
				coordinates.move(0, 5, 0);
				break;
			case FOG:
				coordinates.move(0, 1, 0);
				break;
			case SUN:
				coordinates.move(0, 10, 2);
				break;
			case SNOW:
				coordinates.move(0, 0, -7);
				break;
			default:
				throw new UnknownWeatherException(currentWeatherName); 
		}
		String msg = "JetPlane#" + name + "(" + id + ")";
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
		Printer.getInstance().write("Tower says: JetPlane#" + name + '(' + id + ") registered to weather tower.");
	};

	private void unregister() {
		Printer.getInstance().write("Tower says: JetPlane#" + name + '(' + id + ") unregistered from weather tower.");	
	}
}
