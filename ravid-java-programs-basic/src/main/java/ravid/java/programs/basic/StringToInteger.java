/**
 *  Apr 2, 2012
 */
package ravid.java.programs.basic;

import org.apache.commons.lang.StringUtils;

/**
 * Program to convert string to int.
 *
 * @author Ravi
 */
public class StringToInteger {

	/**
	 * Given an input string, convert it into its equivalent int format.
	 * "180"  = 180;
	 * "-90" = 90;
	 * Returns -1 if input string was null or contains illegal characters.
	 * 
	 * @param input String representation.
	 * @return int representation of input string.
	 */
	public int atoi(String input) {
		if (StringUtils.isBlank(input)) {
			return -1;
		}
		boolean isNegative = false; 
		int start = 0;
		if (input.charAt(0) == '-') {
			isNegative = true;
			start = 1;
		}
		int length = input.length();
		if (start == length) {
			return -1;
		}
		int retValue = 0;
		for (int i = start, j = length - start; i < length; i++, j--) {
			int ch = input.charAt(i) - '0';
			if (ch >= 0 && ch <= 9) {
				retValue += ch * Math.pow(10, j - 1);
			} else {
				return -1;
			}
		}
		return isNegative ? (0 - retValue) : retValue;
	}
}
