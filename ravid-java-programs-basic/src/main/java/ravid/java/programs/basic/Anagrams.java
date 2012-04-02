/**
 *  
 */
package ravid.java.programs.basic;

import org.apache.commons.lang.StringUtils;

/**
 * Program to check if two given strings are anagrams.
 *
 * @author Ravi
 */
public class Anagrams {

	/**
	 * Takes in two String parameters, and checks whether they are anagrams
	 * or not. Returns <code>true</code> if yes otherwise <code>false</code>.
	 * 
	 * @param stringOne The string to compare.
	 * @param stringTwo The string to compare with.
	 * @return <code>true</code> or <code>false</code>.
	 */
	public boolean checkForAnagram(String stringOne, String stringTwo) {
		if ((StringUtils.isBlank(stringOne) || StringUtils.isBlank(stringTwo)) 
				|| (stringOne.length() != stringTwo.length())) {
			return false;
		}
 		if (StringUtils.equals(stringOne, stringTwo)) {
			return true;
		}
		int length = stringOne.length();
		int array[] = new int[length];
		
		for (int i = 0; i < length; i++) {
			array[stringOne.charAt(i) % length] += stringOne.charAt(i);
			array[stringTwo.charAt(i) % length] -= stringTwo.charAt(i);
		}
		
		for (int i = 0; i < length; i++) {
			if (array[i] != 0) {
				return false;
			}
		}
		return true;
	}

}
