// package _42.ajav_launcher.Tower;

// import _42.ajav_launcher.*;
import java.util.Collection;
import java.util.LinkedList;

public class Tower {
	private Collection<Flyable> observers = new LinkedList<Flyable>();

	public void register(Flyable flyable) {
		observers.add(flyable);
	}

	public void unregister(Flyable flyable) {
		observers.remove(flyable);
	}

	protected void conditionsChanged() {
		observers.forEach((observer) -> {
			try {
				observer.updateConditions();
			} catch (Exception err) {
				System.out.println(err);
				System.out.println("Failed to update conditions " + err.getMessage());
			}
		});
	}

	// private void printEvent(Flyable obj, boolean register) { //How to do this in a more clean fashion to handle both register and unregister?
	// 	String msg = "Tower says: ";
	// 	if (obj instanceof Helicopter) {
	// 		msg += "Helicopter";
	// 	}
	// 	msg += "#" + obj.id
	// }
}
