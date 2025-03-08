package wingsteven.passman;

import java.util.HashMap;
import java.util.Map;

public class WordlistUtility {

	public static Map<WordlistType, Wordlist> loadWordlists() {
		Map<WordlistType, Wordlist> wordlists = new HashMap<WordlistType, Wordlist>();
		wordlists.put(WordlistType.LARGE, loadLargeWordlist());
		wordlists.put(WordlistType.SHORT1, loadShortWordlist1());
		wordlists.put(WordlistType.SHORT2, loadShortWordlist2());
		return wordlists;
	}

	public static Wordlist loadLargeWordlist() {
		return new Wordlist(FileUtility.getLargeWordlist());
	}

	public static Wordlist loadShortWordlist1() {
		return new Wordlist(FileUtility.getShortWordlist1());
	}
	
	public static Wordlist loadShortWordlist2() {
		return new Wordlist(FileUtility.getShortWordlist2());
	}

}
