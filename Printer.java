// package ajav_launcher;

import java.io.FileWriter;
import java.io.IOException;

public class Printer {
	private static Printer instance = null;
	private FileWriter fileWriter = null;

	private Printer() {
		try {
			fileWriter = new FileWriter("simulation.txt"); // When do I close this file???
		} catch (IOException err) {
			System.out.println("Could not open file");
			System.exit(0);
		}
	}

	public static Printer getInstance() {
		if (instance == null)
			instance = new Printer();
		return instance;
	}

	public void write(String msg) {
		try {
			fileWriter.write(msg + '\n');
			fileWriter.flush();
		} catch (IOException err) {
			System.out.println("Failed to write to file");
		}
	}
}
