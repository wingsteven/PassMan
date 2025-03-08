package wingsteven.passman;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class FileUtilityTest {

	private static final int SHORT_WORDLIST_LENGTH = 1296;
	private static final int LARGE_WORDLIST_LENGTH = 7776;

	@Test
	void testGetLongWordlist() {
		int expectedLength = LARGE_WORDLIST_LENGTH;
		List<String> longWordlist = FileUtility.getLargeWordlist();
		assertWordlistIsPopulated(longWordlist, expectedLength);
	}
	
	@Test
	void testGetShortWordlist1() {
		int expectedLength = SHORT_WORDLIST_LENGTH;
		List<String> shortWordlist1 = FileUtility.getShortWordlist1();
		assertWordlistIsPopulated(shortWordlist1, expectedLength);
	}

	@Test
	void testGetShortWordlist2() {
		int expectedLength = SHORT_WORDLIST_LENGTH;
		List<String> shortWordlist2 = FileUtility.getShortWordlist2();
		assertWordlistIsPopulated(shortWordlist2, expectedLength);
	}

	private void assertWordlistIsPopulated(List<String> wordlist, int expectedLength) {
		assertNotNull(wordlist);
		assertFalse(wordlist.isEmpty());
		assertEquals(expectedLength, wordlist.size());
	}
}
