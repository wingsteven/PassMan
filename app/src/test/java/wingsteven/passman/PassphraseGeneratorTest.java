package wingsteven.passman;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
class PassphraseGeneratorTest {
	
	private static final int ONE = 1;

	@Test
	void testGeneratePassphrase() {
		PassphraseGenerator pass = new PassphraseGenerator();
		String passphrase = pass.generatePassphrase();
		assertNotNull(passphrase);
		assertFalse(passphrase.isEmpty());
	}

	@Test
	void testGeneratesDifferentPassphrases() {
		PassphraseGenerator pass = new PassphraseGenerator();
		String passphrase = pass.generatePassphrase();
		
		String passphrase2 = pass.generatePassphrase();
		assertNotEquals(passphrase, passphrase2);
	}

	@Test
	void testChangeNumberOfWordsImpactsPassphraseLength() {
		List<String> passphrasesWithDefaultNumberOfWords = getTenPassphrasesWithDefaultNumberOfWords();
		List<String> passphrasesWithOneWord = getTenPassphrasesWithOneWord();
		assertEquals(passphrasesWithDefaultNumberOfWords.size(), passphrasesWithOneWord.size());
		assertLongerPassphrasesAreLonger(passphrasesWithDefaultNumberOfWords, passphrasesWithOneWord);
	}

	private void assertLongerPassphrasesAreLonger(List<String> longerPassphrases, List<String> shorterPassphrases) {
		for (String longerPassphrase : longerPassphrases) {
			System.out.println(longerPassphrase);
			for (String shorterPassphrase : shorterPassphrases) {
				System.out.println(shorterPassphrase);
				assertTrue(longerPassphrase.length() > shorterPassphrase.length(),
						longerPassphrase + " | " + shorterPassphrase);
			}
		}
	}

	private List<String> getTenPassphrasesWithOneWord() {
		PassphraseGenerator pass = new PassphraseGenerator();
		pass.setNumberOfWords(ONE);
		assertEquals(ONE, pass.getNumberOfWords());
		return getTenPassphrases(pass);
	}

	private List<String> getTenPassphrasesWithDefaultNumberOfWords() {
		PassphraseGenerator pass = new PassphraseGenerator();
		assertNotEquals(ONE, pass.getNumberOfWords());
		return getTenPassphrases(pass);
	}

	private List<String> getTenPassphrases(PassphraseGenerator pass) {
		List<String> phrases = new ArrayList<>(10);
		for (int i = 0; i < phrases.size(); i++) {
			phrases.add(pass.generatePassphrase());
		}
		return phrases;
	}

	@Test
	void testChangeNumberOfDigits() {
		final int TWO = 2;
		PassphraseGenerator pass = new PassphraseGenerator();
		assertEquals(TWO, pass.getNumberOfDigits());
		String phrase = pass.generatePassphrase();
		
	}
	
	
}
