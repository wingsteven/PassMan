package wingsteven.passman;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileUtility {

	private static final String RESOURCE_DIR = "src/main/resources/";
	private static final String EFF_LARGE_WORDLIST = "eff_large_wordlist.txt";
	private static final String EFF_SHORT_WORDLIST_1 = "eff_short_wordlist_1.txt";
	private static final String EFF_SHORT_WORDLIST_2 = "eff_short_wordlist_2_0.txt";
	
	private FileUtility() {
		
	}
	
	public static List<String> getLargeWordlist() {
		try {
			return readFile(getWordlistPath(EFF_LARGE_WORDLIST));
		} catch (IOException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}
	
	public static List<String> getShortWordlist1() {
		try {
			return readFile(getWordlistPath(EFF_SHORT_WORDLIST_1));
		} catch (IOException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}
	
	public static List<String> getShortWordlist2() {
		try {
			return readFile(getWordlistPath(EFF_SHORT_WORDLIST_2));
		} catch (IOException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}
	
	private static List<String> readFile(Path filePath) throws IOException {
		return Files.readAllLines(filePath);
	}

	private static Path getWordlistPath(String wordlistFileName) {
		return Paths.get(RESOURCE_DIR + wordlistFileName);
	}
}
