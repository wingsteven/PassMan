package wingsteven.passman;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Wordlist {
	private final Map<String, String> map;
	
	public Wordlist(List<String> wordlist) {
		map = parseList(wordlist);
	}

	public String get(String wordIndex) {
		return map.get(wordIndex);
	}
	
	private Map<String, String> parseList(List<String> wordlist) {
		Map<String, String> wordMap = new HashMap<>();
		for (String word : wordlist) {
			String[] split = word.split("\t");
			wordMap.put(split[0], split[1]);
		}
		return wordMap;
	}
}
