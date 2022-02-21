public class AircraftTypes {
  
  private static String[] types = {
    "Helicopter",
    "Jet"
  };

  public static boolean isKnown(String type) {
    for (String s: types) {
      if (s.equalsIgnoreCase(type)) {
        return true;
      }
    }
    return false;
  }

  public static int getIndex(String type) {
    for (int i = 0; i < types.length; i++) {
      if (type.equalsIgnoreCase(types[i])) {
        return i;
      }
    }
    return -1;
  }
}
