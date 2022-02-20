// package _42.ajav_launcher.Tower;

// import _42.ajav_launcher.*;
import java.util.Collection;
import java.util.Iterator;
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
		Iterator<Flyable> itr = observers.iterator();
		while (itr.hasNext()) {
			Flyable next = itr.next();
			try {
				next.updateConditions();
				if (next.hasLanded()) {
					itr.remove();
				}
			} catch (Exception err) {
				System.out.println(err);
				System.out.println("Failed to update conditions " + err.getMessage());
			}
		}
	}
}
