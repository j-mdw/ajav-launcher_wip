// package ajav_launcher;

import java.util.Collection;
import java.util.LinkedList;

public class SimulationInputs {
	public int repetitions;
	public Collection<Flyable> flyables;

  public SimulationInputs() {
    flyables = new LinkedList<Flyable>();
  }
}
