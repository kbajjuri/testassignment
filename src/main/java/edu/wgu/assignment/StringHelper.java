/**
 * 
 */
package edu.wgu.assignment;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The <code>StringHelper</code> class providers helper methods to manipulate strings.
 * @author Koti Bajjuri
 */
public class StringHelper {
	
	/**
	 * Constructs a string with the first letter of the word, 
	 * the count of distinct letters between the first and last letter, and the last letter of the word.
	 * @param str
	 * 		  - String to construct with new format.
	 * @return Formatted string with first letter of the word, the count of distinct letters in between first and last letter, and the last letter.
	 * @throws <code>UnsupportedEncodingException</code> - throws when the given string is unsupported of US-ASCII character set. 
	 */
	public String getDistinctLettersBetweenFirstAndLastLetters(String str) throws UnsupportedEncodingException {
		
		if(str == null || str.trim().isEmpty()) {
			return null;
		}
		String strToFindDistinct = str.substring(1, str.length()-1);
		
		byte[] asciiValues = strToFindDistinct.getBytes("US-ASCII");
		
		StringBuilder formattedStr = new StringBuilder(str.substring(0,1));
		
		Set<Byte> setOfDistinctChars = new HashSet<Byte>(); 
		
		// Time complexity is O(N) of the substring because the process has to look through to find distinct.
		for (byte b : asciiValues) {
			//All the time complexity here is O(1) because everything here do the same logic.
			if((b>= 65 && b<= 90) || (b>= 97 && b<= 122)) {
				setOfDistinctChars.add(b);
			} else {
				//If the first character in the string itself a non-alphabet needs to append to string.
				if(setOfDistinctChars.size()==0) {
					formattedStr.append((char)b);
				} else {
					//Appending the size before appending the length.
					formattedStr.append(setOfDistinctChars.size());
					formattedStr.append((char)b);
					setOfDistinctChars.clear();
				}	
			}
		}
		formattedStr.append(setOfDistinctChars.size());
		formattedStr.append(str.charAt(str.length()-1));
		return formattedStr.toString();
	}
	
	/**
	 * Main method to launch the String helper class.
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception{
		StringHelper sh = new StringHelper();
		System.out.println(sh.getDistinctLettersBetweenFirstAndLastLetters("AutoMmotive_koti"));
	}
}
