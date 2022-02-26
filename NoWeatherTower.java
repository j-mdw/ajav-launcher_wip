// package ajav_launcher;

import java.lang.Exception;

public class NoWeatherTower extends Exception {
  public NoWeatherTower() {
    super("Flyable has no weather tower");
  }
}
