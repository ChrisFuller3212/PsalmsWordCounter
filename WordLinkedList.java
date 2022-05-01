import java.io.*;
import java.util.*;
/**
 * WordCountNode class - The data portion of the linked list
 */
class WordCountNode	{
	String word;
	int count;
	
	/**
	 * WordCountNode constructor
	 * @param inWord
	 */
	public WordCountNode(String inWord) {
		word = inWord;
		count = 1;
	}	
	
	/**
	 * @return the object word datum
	 */
	public String getWord() {
		return word;
	}
	
	/**
	 * @return the object count datum
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @return the object count auto-incremented
	 */
	public int incrementCount() {
		count++;
		return count;
	}
}
/**
 * 
 * @author CFuller
 * 
 * Description: The implementation of WordList
 * using the Java build-in LinkedList.
 */
public class WordLinkedList extends WordList {
	static LinkedList<WordCountNode> words = new LinkedList<WordCountNode>();
	static int lastIndex = 0;
	
	/**
	 * Public constructor method WordLinkedList
	 */
	public WordLinkedList() {
		super();
		lastIndex = 0;
	}
	
	/**
	 * Public method findWord
	 * @param inWord String
	 * @return 0 if inWord not found, inWord count if found
	 */
	public int findWord(String inWord) {
		boolean foundWord = false;
		
//		list iterator listOfWords used to loop through the linked list
		ListIterator<WordCountNode> listOfWords = words.listIterator();
		while (listOfWords.hasNext()) {
			WordCountNode n = (WordCountNode) listOfWords.next();
			if (inWord.compareTo(n.getWord()) == 0) {
//				incrementCount() used from WordCountNode class
				n.incrementCount();
				foundWord = true;
				break;
			}
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
		boolean foundWord = false;
		
//		list iterator listOfWords used to loop through the linked list
		ListIterator<WordCountNode> listOfWords = words.listIterator();
		while (listOfWords.hasNext()) {
			WordCountNode n = (WordCountNode) listOfWords.next();
			if (inWord.compareTo(n.getWord()) == 0) {
//				incrementCount() used from WordCountNode class
				super.incTotalAllWords();
				n.incrementCount();
				foundWord = true;
				break;
			}
		}
		//if the word is not found in list, add to end of list
		if (!foundWord) {
			super.incNumUniqueWords();
			super.incTotalAllWords();
			words.add(new WordCountNode(inWord));
		}
		return 1;
	}
	
	/**
	 * Public method incWord
	 * @param inWord String
	 * @return 0 if inWord not found, new inWord count if found
	 */
	public int incWord(String inWord) {
		boolean foundWord = false;
		int index = 0;
		
//		list iterator listOfWords used to loop through the linked list
		ListIterator<WordCountNode> listOfWords = words.listIterator();
		while (listOfWords.hasNext()) {
			WordCountNode n = (WordCountNode) listOfWords.next();
			if (inWord.compareTo(n.getWord()) == 0) {
//				incrementCount() used from WordCountNode class
				n.incrementCount();
				foundWord = true;
				break;
			}
		}
		if (foundWord) {
			super.incNumUniqueWords();
			super.incTotalAllWords();
			return lastIndex;
		} else {
			return 0;
		}
	}
	
	/**
	 * Public method printWordList
	 * @param inMinimum int
	 */
	public void printWordList(int inMinimum) {
		System.out.println(super.toString());
		for (int i = 0; i < words.size(); i++) {
			if (words.get(i).getCount() >= inMinimum) {
				System.out.println(words.get(i).getWord() + ':' + words.get(i).getCount());
			}
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
