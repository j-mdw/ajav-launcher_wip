// package ajav_launcher;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class Parser {

  AircraftFactory factory = null;

  public Parser() {
    this.factory = new AircraftFactory();
  }

  public SimulationInputs parseSimulation(String filename) throws FileNotFoundException, IOException, UnexpectedTokenException, NumberFormatException {
    SimulationInputs simulationInputs = new SimulationInputs();
    FileReader file = new FileReader(filename);
    BufferedReader reader = new BufferedReader(file);
  
    String line = reader.readLine();
    int lineNumber = 1;
    try {
      int repetitions = Integer.parseInt(line);
      simulationInputs.repetitions = repetitions;
    } catch (NumberFormatException err) {
      throw new UnexpectedTokenException(line, lineNumber);
    }
    lineNumber++;
    line = reader.readLine();
    while (line != null) {
      String[] tokens = line.trim().split("\\s+");
      try {
        Flyable flyable = parseLine(tokens);
        simulationInputs.flyables.add(flyable);
      } catch (UnexpectedTokenException ute) {
        throw new UnexpectedTokenException(ute.token, lineNumber);
      }
      lineNumber++;
      line = reader.readLine();
    }
    reader.close();
    file.close();
    return simulationInputs;
  }

  private Flyable parseLine(String[] tokens) throws UnexpectedTokenException {
    if (tokens.length != 5) {
      throw new UnexpectedTokenException(tokens[0]);
    }
    verifyType(tokens[0]);
    
    int longitude, latitude, height;
    try {
      longitude = Integer.parseInt(tokens[2]);
      latitude = Integer.parseInt(tokens[3]);
      height = Integer.parseInt(tokens[4]);
    } catch (NumberFormatException err) {
      throw new UnexpectedTokenException(tokens[2] + " " + tokens[3] + " " + tokens[4]);
    }
    verifyCoordinates(longitude, latitude, height);
    return this.factory.newAircraft(tokens[0], tokens[1], longitude, latitude, height);
  }

  private void verifyType(String type) throws UnexpectedTokenException {
    if (!AircraftTypes.isKnown(type)) {
      throw new UnexpectedTokenException(type);
    }
  }

  private void verifyCoordinates(int longitude, int latitude, int height) throws UnexpectedTokenException {
    if (longitude < 0) {
      throw new UnexpectedTokenException(String.valueOf(longitude));
    }
    if (latitude < 0) {
      throw new UnexpectedTokenException(String.valueOf(latitude));
    }
    if (height < 0 || height > 100) {
      throw new UnexpectedTokenException(String.valueOf(height));
    }
  }
}
