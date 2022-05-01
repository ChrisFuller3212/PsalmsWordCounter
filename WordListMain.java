import java.io.*;
import java.util.*;

/**
 * 
 * @author TMyatt (modified by CFuller)
 * 
 */
public class WordListMain {

	/**
	 * 
	 * @param inLine String
	 * @return
	 */
	static String getVerse(String inLine) {
		String[] ver = inLine.split("\t");
		return ver[1];
	}
	
	/**
	 * 
	 * @param args String[]
	 */
	public static void main(String[] args) {
		long mSec, mSecSum = 0;
		try {
			// Open the required text file for sequential read
			Scanner inputFile =
					new Scanner (new File(args[0]));
			
			WordArrayList wordArrayList = null;
			WordLinkedList wordLinkedList = null;
			WordHashMap wordHashMap = null;
			
			switch (args[1]) {
			case "A" :
				wordArrayList = new WordArrayList();
				break;
			case "L" :
				wordLinkedList = new WordLinkedList();
				break;
			case "H" :
				wordHashMap = new WordHashMap();
				break;
			default: System.out.println("ERROR at argc[1]");
				break;
			}
			
			// Check for EOF, read the next line, and display it
			while (inputFile.hasNextLine()) {
				String inLine, verse;
				String[] verseParsed;
				
				inLine = inputFile.nextLine();
				verse = getVerse(inLine);
				verseParsed = verse.split("[ :;,.'!?()-]+");
				// We're going to do a millisecond execution calc
				mSec = System.nanoTime()/1000000;
				for (String s: verseParsed) {
					switch (args[1]) {
					case "A" :
						wordArrayList.addWord(s.toLowerCase());
						break;
					case "L" :
						wordLinkedList.addWord(s.toLowerCase());
						break;
					case "H" :
						wordHashMap.addWord(s.toLowerCase());
						break;
					default: System.out.println("ERROR at argc[1]");
						break;
					}
				}
				mSecSum += (System.nanoTime()/1000000 - mSec);
			}		
			// Close the required file when EOF is reached
			inputFile.close();
			switch (args[1]) {
			case "A" :
				wordArrayList.printWordList(Integer.parseInt(args[2]));
				break;
			case "L" :
				wordLinkedList.printWordList(Integer.parseInt(args[2]));
				break;
			case "H" :
				wordHashMap.printWordList(Integer.parseInt(args[2]));
				break;
			default: System.out.println("ERROR at argc[2]");
				break;
			}
	        System.out.println("Elapsed Time: " + mSecSum + " ms");
		} // END try
		catch (Exception e) {
			// All Exceptions come here for graceful termination
			System.out.println("PsalmsReaderMain Error: " + e);
		} // END catch		
	} // END main
} // END class
