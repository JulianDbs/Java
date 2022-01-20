import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

import java.lang.NullPointerException;

public class Main {

	public static void main(String[] args) {
		Console console = new Console();
		console.start();
	}
}


class Console {
	private Scanner scanner;

	public Console() {
		scanner = new Scanner(System.in);
	}

	public void clearScreen() {
		System.out.println("\033[H\033[2J");
		System.out.flush();
		scanner.reset();
	}

	public void start() {
		clearScreen();
		System.out.format("\tProgram Start%n\tPress any Key and Enter to read the file%n%n\tKey : ");
		String key = scanner.nextLine();
		System.out.println("key : " + key);
		if (key.equals("")) {
			start();
		} else {
			findAndShowFile();
		}
	}

	private void findAndShowFile() {
		clearScreen();
		try {
			File text = new File("text.txt");
			Scanner textContent = new Scanner(text);
			clearScreen();
			System.out.format("\ttext.txt file content : %n%n");
			while (textContent.hasNextLine()) {
				String line = textContent.nextLine();
				System.out.println("\t" + line);
			}
			textContent.close();
			System.out.println("");
			System.out.println("\tProgram End.");
		} catch (NullPointerException npe) {
			messageFilePathIsNull();
		} catch (FileNotFoundException fnfe) {
			messageFileNotFound();
		}
	}

	private void messageFileNotFound() {
		clearScreen();
		System.out.format("\tError : %n%n\tFile nout found, please check if the text.txt file is in the main folder.%n%n\tPress any Key and Enter to Close the Programm...%n\tKey : ");
		String key = scanner.nextLine();
		if (key.equals("")) {
			messageFileNotFound();
		} else {
			clearScreen();
		}
	}

	private void messageFilePathIsNull() {
		clearScreen();
		System.out.format("\tInternal Error : %n%n\tThe path of the file is null, please check the code.%n%n\tPress any Key and Enter to Close the Program...%n\tKey : ");
		String key = scanner.nextLine();
		if (key.equals("")) {
			messageFilePathIsNull();
		} else {
			clearScreen();
		}
	}
}
