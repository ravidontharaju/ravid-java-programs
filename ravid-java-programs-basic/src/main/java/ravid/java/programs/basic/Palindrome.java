/**
 *  Copyright Ravi Dontharaju :)
 */
package ravid.java.programs.basic;

import org.apache.commons.lang.StringUtils;

/**
 * Program to check whether a given string is Palindrome or not.
 *
 * @author Ravi
 */
public class Palindrome {

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
