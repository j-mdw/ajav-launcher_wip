// package ajav_launcher;

interface Flyable {
	public void updateConditions() throws UnknownWeatherException, NoWeatherTower;
	public void registerTower(WeatherTower weatherTower);
	public boolean hasLanded();
}
