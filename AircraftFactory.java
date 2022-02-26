// package ajav_launcher;

public class AircraftFactory {

  interface FlyableCreator {
    public Flyable create(String name, Coordinates coordinates);
  }

  private FlyableCreator[] flyableCreators = new FlyableCreator[] {
    new FlyableCreator() { public Flyable create(String name, Coordinates coordinates) { return new Helicopter(name, coordinates); } },
    new FlyableCreator() { public Flyable create(String name, Coordinates coordinates) { return new JetPlane(name, coordinates); } },
    new FlyableCreator() { public Flyable create(String name, Coordinates coordinates) { return new Baloon(name, coordinates); } }
  };

  public Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
    Coordinates coordinates = new Coordinates(longitude, latitude, height);
    int index = AircraftTypes.getIndex(type);
    if (index >= 0) {
      return flyableCreators[index].create(name, coordinates);
    }
    return null;
  }
}
