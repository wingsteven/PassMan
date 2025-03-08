package wingsteven.passman;

public class PassphraseGenerator {

	private int numberOfWords = 6;
	private int numberOfDigits = 2;

	public String generatePassphrase() {
		Wordlist largeWordlist = WordlistUtility.loadLargeWordlist();
		int[] rolls = DiceRoller.rollXd6Individual(5);
		String wordIndex = "";
		for (int roll : rolls) {
			wordIndex = wordIndex + roll;
		}
		String passphrase = largeWordlist.get(wordIndex);
		return passphrase;
	}

	public int getNumberOfWords() {
		return numberOfWords;
	}

	public void setNumberOfWords(int numberOfWords) {
		this.numberOfWords = numberOfWords;
	}

	public int getNumberOfDigits() {
		return numberOfDigits;
	}

	public void setNumberOfDigits(int numberOfDigits) {
		this.numberOfDigits = numberOfDigits;
	}
}
