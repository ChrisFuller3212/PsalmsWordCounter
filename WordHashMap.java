import java.io.*;
import java.util.*;
/**
 * 
 * @author CFuller
 * 
 * Description: The implementation of WordList
 * using the Java build-in HashMap.
 */
public class WordHashMap extends WordList {
	static HashMap<String, Integer> wordsHash = new HashMap<String, Integer>();
	static int lastIndex = 0;
	
	/**
	 * Public constructor method WordHashMap
	 */
	public WordHashMap() {
		super();
		lastIndex = 0;
	}
	
	/**
	 * Public method findWord
	 * @param inWord String
	 * @return 0 if inWord not found, inWord count if found
	 */
	public int findWord(String inWord) {
		if (wordsHash.containsKey(inWord)) {
			wordsHash.get(inWord);
		}
		return 0;
	}
	
	/**
	 * Public method existsWord
	 * @param inWord String
	 * @return True if inWord exists in WordList
	 */
	public boolean existsWord(String inWord) {
		if (findWord(inWord) == 0) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * Public method addWord
	 * @param inWord String
	 * @return 1 if inWord not found, new inWord count if found
	 */
	public int addWord(String inWord) {
		if (wordsHash.containsKey(inWord)) {
			super.incTotalAllWords();
			wordsHash.put(inWord,  wordsHash.get(inWord) + 1);
		} else {
			super.incNumUniqueWords();
			super.incTotalAllWords();
			wordsHash.put(inWord,  1);
		}
		
		return 1;
	}
	
	/**
	 * Public method incWord
	 * @param inWord String
	 * @return 0 if inWord not found, new inWord count if found
	 */
	public int incWord(String inWord) {
		if (wordsHash.containsKey(inWord)) {
			wordsHash.put(inWord,  wordsHash.get(inWord) + 1);
		} else {
			super.incTotalAllWords();
			wordsHash.put(inWord,  1);
		}
		return 0;
	}
	
	/**
	 * Public method printWordList
	 * @param inMinimum int
	 */
	public void printWordList(int inMinimum) {
		System.out.println(super.toString());
		for (String i : wordsHash.keySet()) {
//			to remove the blank space at the beginning of the loop
			if (i == "") {
				
			} else if (wordsHash.get(i) < inMinimum) {
				
			} else if (wordsHash.get(i) >= inMinimum) {
				System.out.println(i + ": " + wordsHash.get(i));
			}
		}	
			
		if (wordsHash.size() > 0) {
			System.out.println("Total words: " + wordsHash.size());
		}
	}
	
	/**
	 * Public string method toString
	 * @return A string with Unique Words and Total Word Count
	 */
	public String toString() {
		return super.toString();
	}
}
