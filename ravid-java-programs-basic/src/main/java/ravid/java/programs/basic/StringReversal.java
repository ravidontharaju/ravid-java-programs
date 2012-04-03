/**
 *  Apr 2, 2012
 */
package ravid.java.programs.basic;

import org.apache.commons.lang.StringUtils;

/**
 * Program to reverse the words in a string and reverse a word.
 *
 * @author Ravi
 */
public class StringReversal {

	/**
	 * Reverses the given input word.
	 * 
	 * @param input The string to reverse.
	 * @return Reversed string value of input.
	 */
	public String reverseWord(String input) {
		if (StringUtils.isBlank(input)) {
			return input;
		}
	
		input = input.trim();
		int length = input.length();
		char[] array = new char[length];
		for (int i = 0, j = length - 1; i < length / 2; i++, j--) {
			array[i] = input.charAt(j);
			array[j] = input.charAt(i);
		}
		if (length % 2 != 0) {
			array[length / 2] = input.charAt(length / 2);
		}
		return new String(array);
	}
	
	/**
	 * Reverse the words given in the input line.
	 * 
	 * @param input A line containing one or more words.
	 * @return The line in its reverse format.
	 */
	public String reverseLine(String input) {
		if (StringUtils.isBlank(input)) {
			return input;
		}
		
		input = reverseWord(input);
		
		String retVal = "";
		int startIndex = 0;
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == ' ') {
				retVal = retVal + " " + reverseWord(input.substring(startIndex, i));
				startIndex = i;
			}
		}
		retVal = retVal + " " + reverseWord(input.substring(startIndex, input.length()));
		return retVal.trim();
	}
}
