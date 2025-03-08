package wingsteven.passman;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Test;

class WordlistUtilityTest {

	@Test
	void testLoadWordlists() {
		Map<WordlistType, Wordlist> wordlists = WordlistUtility.loadWordlists();
		assertNotNull(wordlists);
		assertFalse(wordlists.isEmpty());
	}

	@Test
	void testLoadLargeWordlist() {
		Wordlist largeWordlist = WordlistUtility.loadLargeWordlist();
		assertNotNull(largeWordlist);
		String wordIndex = "11111";
		String expected = "abacus";
		String actual = largeWordlist.get(wordIndex);
		assertEquals(expected, actual);
	}

	@Test
	void testLoadShortWordlist1() {
		Wordlist shortWordlist1 = WordlistUtility.loadShortWordlist1();
		assertNotNull(shortWordlist1);
		String wordIndex = "1111";
		String expected = "acid";
		String actual = shortWordlist1.get(wordIndex);
		assertEquals(expected, actual);
	}

	@Test
	void testLoadShortWordlist2() {
		Wordlist shortWordlist2 = WordlistUtility.loadShortWordlist2();
		assertNotNull(shortWordlist2);
		String wordIndex = "1111";
		String expected = "aardvark";
		String actual = shortWordlist2.get(wordIndex);
		assertEquals(expected, actual);
	}
}
