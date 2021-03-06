// package ajav_launcher;

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
		if (height > 100) {
			height = 100;
		}
	}

	public int getLongitude() { return longitude; }
	public int getLatitude() { return latitude; }
	public int getHeight() { return height; }
}