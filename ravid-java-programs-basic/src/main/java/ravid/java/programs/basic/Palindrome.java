/**
 *  
 */
package ravid.java.programs.basic;

import org.apache.commons.lang.StringUtils;

/**
 * Program to check whether a given string is Palindrome or not.
 *
 * @author Ravi
 */
public class Palindrome {

	/**
	 * Checks whether the given input string is a palindrome or not.
	 * eg: 
	 * - "testtest" will return <code>true</code>.
	 * - "test" will return <code>false</code>.
	 * - empty or null input will return <code>false</code>.
	 * 
	 * @param input The input to check.
	 * @return <code>true</code> or <code>false</code>.
	 */
	public boolean checkForPalindrome(String input) {
		if (StringUtils.isEmpty(input)) {
			return false;
		}
		int length = input.length();
		for (int i = 0, j = length - 1; i < length /2; i++, j--) {
			if (input.charAt(i) != input.charAt(j)) {
				return false;
			}
		}
		return true;
	}
}
