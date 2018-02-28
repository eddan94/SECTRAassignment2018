package sizeEstimator;
import java.util.Locale;
import java.util.Scanner;


/**
 * Estimator v.1.0.0
 * @author edvinmodigh
 * Estimator contains main and a function for executing lines from input 
 * Created 2017-02-26 in Eclipse Oxygen.1a Release (4.7.1a)
 */
public class Estimator {
	
	/**
	 * @param args default main JAVA
	 * main function writes text to user and waits for input
	 * @throws OperationsException 
	 * 
	 */
	public static void main(String[] args) {
		
		printHeader();
		
		// New instance of ImageHandler 
		ImageHandler ih = new ImageHandler();

		// Scanner on the standard input from console
		Scanner sc = new Scanner(System.in);		

		// Line scanned in by scanner
		String line;
	
		// execute line-inputs until "q" or "Q" is entered as a line
		while (true) {
			line = sc.nextLine();
			if (line.equalsIgnoreCase("q")) {
				break;
			}
			excecute(line.split(" "), ih);
		}

		// Close scanner, set integer presentation to PL to print in format "X XYZ XYZ"
		sc.close();
		Locale.setDefault(new Locale("pl", "PL"));
		System.out.println("Total size: " + String.format("%,d", ih.getSize()) + " bytes");
	}

	/**
	 * Prints header and info 
	 */
	private static void printHeader() {
		System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("		===============================");
		System.out.println("		-->       Edvin Modigh      <--");
		System.out.println("		===============================");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
		System.out.println("Image storage calculator by Edvin Modigh. " + 
				"\nEnter one line for each image/group on the format: \n\"type width " + 
				"height\", or \"G i i ...\" \nExit with \"Q\" or \"q\".\n");	
	}

	/**
	 * Sends input to image distributor or grouper after identifying input type
	 * @param st is splitted input line
	 * @param ih is current instance of ImageHandler
	 */
	private static void excecute(String[] st, ImageHandler ih) {
		
		try {
			// If input is a group input, send st to group
			if (st[0].matches("G")) {
				ih.group(st);
			} else {
				// If input is image input, first check # of objects
				// if correct (3) send st to distributor
				if (st.length != 3) {
					throw new Exception("Wrong nr of inputs");
				}
				// send input to image distributor
				ih.distribute(st);
			}

		// Catching errors to stop termination
		} catch (Exception e) {
			// Printing error info without terminating program
			System.err.println("\"" + String.join(" ", st) + "\" is not a valid input ---> " + e);
		}
	}
}


