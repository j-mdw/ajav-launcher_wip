// package _42.ajav_launcher.Coordinates;

public class Coordinates {
	private int longitude;
	private int latitude;
	private int height;

	public Coordinates(int longitude, int latitude, int height) {
		this.longitude = longitude;
		this.latitude = latitude;
		this.height = height;
	}

	public void move(int longitudeChange, int latitudeChange, int heightChange) {
		longitude += longitudeChange;
		latitude += latitudeChange;
		height += heightChange;
	}

	public int getLongitude() { return longitude; }
	public int getLatitude() { return latitude; }
	public int getHeight() { return height; }
}