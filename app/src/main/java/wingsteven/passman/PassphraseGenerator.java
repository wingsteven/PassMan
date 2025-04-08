package wingsteven.passman;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class PassphraseGenerator {

	private int numberOfWords = 6;
	private int numberOfDigits = 2;
	private int numberOfSpecials = 2;
	private Wordlist activeWordlist;
	private WordlistType activeType = WordlistType.LARGE;
	private final Map<WordlistType, Wordlist> wordlists;
	private final List<Character> specialCharacterList = Arrays.asList('!','@','#','$','%','^','&','*','(',')','-','_','=','+','[','{',']','}','\\','|',';',':','\'','"',',','<','.','>','/','?','`','~');

	public PassphraseGenerator() {
		wordlists = WordlistUtility.loadWordlists();
		activeWordlist = wordlists.get(activeType);
	}

	public String generatePassphrase() {
		List<String> phrasePieces = generateWords();
		phrasePieces.addAll(generateDigits());
		phrasePieces.addAll(generateSpecialCharacters());
		Collections.shuffle(phrasePieces, new SecureRandom());
		return String.join("", phrasePieces);
	}

	public List<String> generateWords() {
		List<String> words = new ArrayList<String>(numberOfWords);
		for (int i = 0; i < numberOfWords; i++) {
			words.add(getRandomWord());
		}
		return words;
	}

	private String getRandomWord() {
		return activeWordlist.get(getRandomKey());
	}

	private String getRandomKey() {
		int[] rolls = DiceRoller.rollXd6Individual(activeType.getDiceCount());
		String wordIndex = "";
		for (int roll : rolls) {
			wordIndex = wordIndex + roll;
		}
		return wordIndex;
	}

	public List<String> generateDigits() {
		List<String> digits = new ArrayList<String>();
		for (int i = 0; i < numberOfDigits; i++) {
			digits.add(DiceRoller.getRandomDigit());
		}
		return digits;
	}

	public List<String> generateSpecialCharacters() {
		List<String> specials = new ArrayList<String>();
		for (int i = 0; i < numberOfDigits; i++) {
			specials.add(getRandomSpecial());
		}
		return specials;
	}

	public String getRandomSpecial() {
		return String.valueOf(specialCharacterList.get(DiceRoller.roll1dY(specialCharacterList.size())));
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

	public int getNumberOfSpecials() {
		return numberOfSpecials;
	}

	public void setNumberOfSpecials(int numberOfSpecials) {
		this.numberOfSpecials = numberOfSpecials;
	}

	public List<Character> getSpecialCharacterList() {
		return specialCharacterList;
	}

	public WordlistType getActiveWordlistType() {
		return activeType;
	}

	public void setActiveWordlist(WordlistType type) {
		activeType = type;
		activeWordlist = wordlists.get(activeType);
	}

	public String getFirstWordInActiveWordlist() {
		return activeWordlist.get(getFirstWordKey());
	}
	
	private String getFirstWordKey() {
		String key = "";
		for (int i = 0; i < activeType.getDiceCount(); i++) {
			key = key + "1";
		}
		return key;
	}
}
