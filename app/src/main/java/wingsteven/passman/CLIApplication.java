package wingsteven.passman;

import java.util.Scanner;

public class CLIApplication {

	private static final String NEWLINE = "%n";
	private static final int MAX_ATTEMPTS = 5;
	private static final String INVALID_SELECTION = "Invalid Selection";
	private static final String SELECTION_FAILED = "Selection Failed";
	private static final String EXIT = "exit";
	private static Scanner userInput;

	public static void main(String[] args) {
		userInput = new Scanner(System.in);
		System.out.println("Welcome to PassMan, the passphrase manager");
		boolean run = true;
		while (run) {
			System.out.println("Select an option:");
			System.out.println("1) Generate Passphrase");
			System.out.println("2) Create Vault");
			System.out.println("3) Open Vault");
			System.out.println("4) Exit");
			String selection = userInput.next();
			switch (selection) {
			case "1":
				generatePassphrase();
				break;
			case "2":
				createVault();
				break;
			case "3":
				openVault();
				break;
			case "4":
				exit();
				break;
			default:
				break;
			}
		}
	}

	private static void generatePassphrase() {
		System.out.println("Generate Passphrase");
		PassphraseGenerator pg = new PassphraseGenerator();
		pg.setActiveWordlist(selectWordlist());
		pg.setNumberOfWords(selectNumberOfWords());
		pg.setNumberOfDigits(selectNumberOfDigits());
		pg.setNumberOfSpecials(selectNumberOfSpecials());
		System.out.println(pg.generatePassphrase());
	}

	private static WordlistType selectWordlist() {
		System.out.println("Select a wordlist to use:");
		System.out.println("1) Long wordlist\n2) Short wordlist 1\n3) Short wordlist 2");
		String input = userInput.next();
		WordlistType wt = WordlistType.LARGE;
		switch (input) {
		case "2":
			wt = WordlistType.SHORT1;
			break;
		case "3":
			wt = WordlistType.SHORT2;
			break;
		default:
			break;
		}
		return wt;
	}

	private static int selectNumberOfWords() {
		return selectNumber("Enter the number of words to usein the passphrase: ");
	}

	private static int selectNumberOfDigits() {
		return selectNumber("Enter the number of digits to use: ");
	}

	private static int selectNumberOfSpecials() {
		return selectNumber("Enter the number of special characters to use: ");
	}

	private static int selectNumber(String prompt) {
		while (true) {
			System.out.println(prompt);
			String input = userInput.next();
			try {
				return Integer.parseInt(input);
			} catch (NumberFormatException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private static void createVault() {
		System.out.println("Create Vault");
		boolean run = true;
		while (run) {
			System.out.println("Enter passphrase to add to the vault or \"Exit\" to exit: ");
			String input = userInput.next();
			if (EXIT.equalsIgnoreCase(input)) {
				run = false;
			}
		}
		System.out.println("Saving Vault");
	}
	
	private static void openVault() {
		System.out.println("Open Vault");
	}
	
	private static void exit() {
		System.out.println("Thank you for using PassMan, the passphrase manager!");
		System.exit(0);
	}
	
	private static void errorExit() {
		System.out.println("Our apologies for this error.\nThank you for using PassMan, the passphrase manager!");
		System.exit(1);
	}
	
	private static int getUserSelection(String[] menuScript) {
		int counter = 0;
		boolean run = true;
		int userSelection = 0;
		int choices = menuScript.length - 1;
		String validSelections = String.format("[1-%d]", choices);
		String input;
		while (run) {
			counter++;
			System.out.println(String.join(NEWLINE, menuScript));
			input = userInput.nextLine();
			if (input.matches(validSelections)) {
				userSelection = Integer.parseInt(input);
				run = false;
			} else if (MAX_ATTEMPTS > counter) {
				System.err.printf(INVALID_SELECTION, input);
			} else {
				System.err.println(SELECTION_FAILED);
				run = false;
			}
		}
		return userSelection;
	}
}
