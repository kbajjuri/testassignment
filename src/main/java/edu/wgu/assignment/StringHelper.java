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
			if(Character.isAlphabetic(b)) {
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
	 * Constructs a string with the first letter of the word, the count of distinct letter between the first and last letter, and the last letter of the word.
	 * @param str - Str to construct with the first letter of the word, the count of distinct letter between the first and last letter, and the last letter of the word.
	 * @return Formatted string with first letter of the word, the count of distinct letters in between first and last letter, and the last letter.
	 */
	public String getDistinctLettersOfEachWord(String str) throws UnsupportedEncodingException{
		if(str==null || str.trim().isEmpty()) {
			return "";
		}
		StringBuilder newString = new StringBuilder();
		byte[] allStringBytes = str.getBytes("US-ASCII");
		int wordStart = 0;
		Set<Character> uniqueCharSet = new HashSet<Character>();
		int i = 0;
		char previousChar = (char)allStringBytes[0];
		int currentStrLocation = 0;
		for (byte b : allStringBytes) {
			if(!Character.isAlphabetic(b) || currentStrLocation == allStringBytes.length-1) {
				if(uniqueCharSet.size()>0) {
					newString.append(uniqueCharSet.size());
					if(currentStrLocation != allStringBytes.length-1 || !Character.isAlphabetic(b)) {
						newString.append(previousChar);
					}
					uniqueCharSet.clear();
				}
				newString.append((char)b);
				i=0;
			} else {
				if(i == wordStart) {
					newString.append((char)b);
				} else {
					if(Character.isAlphabetic(allStringBytes[currentStrLocation+1])){
						uniqueCharSet.add((char)b);
					}
				}
				i++;
				previousChar = (char)b;
				
			}
			currentStrLocation++;
		}
		return newString.toString();
	}
	
	/**
	 * Main method to launch the String helper class.
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception{
		StringHelper sh = new StringHelper();
		//System.out.println(sh.getDistinctLettersBetweenFirstAndLastLetters("AutoMmotive_koti"));
		//
		System.out.println(sh.getDistinctLettersOfEachWord("Autom_otive"));
		System.out.println(sh.getDistinctLettersOfEachWord("Y_ooo3yesss_IAMDOING_dGOOD"));
		System.out.println(sh.getDistinctLettersOfEachWord("Y_ooo3yesss_IAMDOINGdGOOD"));
		
		
		System.out.println(sh.getDistinctLettersOfEachWord("Automotive"));
		//$$$Autom&
		System.out.println(sh.getDistinctLettersOfEachWord("$$$Autom&oive&"));
		
		
		
		
	}
}
