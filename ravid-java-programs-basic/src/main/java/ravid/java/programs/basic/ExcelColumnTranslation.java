/**
 *  
 */
package ravid.java.programs.basic;

import org.apache.commons.lang.StringUtils;

/**
 * Program to translate Excel columns into integer and vice-versa.
 * example, A = 1, B = 2, C = 3,..., Z = 26 and AA = 27; and vice-versa.
 *
 * @author Ravi
 */
public class ExcelColumnTranslation {

	/**
	 * Function which returns an int representation of Excel column values.
	 * Returns 0 if a null or empty value or non-alphabets are passed.
	 * 
	 * @param column The column header to translate.
	 * @return the int representation.
	 */
	public int excelColumnInInt(String column) {
		if (StringUtils.isEmpty(column)) {
			return 0;
		}
		int length = column.length();
		int retVal = 0;
		int power = length;
		for (int i = length - 1; i >= 0; i--) {
			char ch = column.charAt(i);
			if (isValidChar(ch)) {
				ch = toUpper(ch);
				retVal += 
					Math.pow(26, length - power) * (ch - 64);
				power--;
			}
		}
		return retVal;
	}

	/**
	 * Checks whether input is in lower case, if yes then returns the upper case
	 * of the input char.
	 * 
	 * @param ch input char.
	 * @return Upper cased char.
	 */
	private char toUpper(char ch) {
		if (ch >= 'a' && ch <= 'z') {
			return (char)(ch - 32);
		}
		return ch;
	}

	/**
	 * Checks to see whether the input char is of type [a-zA-Z].
	 * 
	 * @param ch input char.
	 * @return <code>true</code> if valid char, otherwise <code>false</code>.
	 */
	private boolean isValidChar(char ch) {
		if ((ch >= 'A' && ch <= 'Z') ||
				(ch >= 'a' && ch <= 'z')) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * Given a int value, translates it into its equivalent Excel column.
	 * Setting no upper limit for value, technically the cell cannot be more
	 * than XFD (16384); And hence using a StringBuilder instead of a simple
	 * String class.
	 * 
	 * @param value The int value to translate.
	 * @return Equivalent {@link String} representation.
	 */
	public String intToExcelColumn(int value) {
		int tempValue = value;
		StringBuilder sb = new StringBuilder();
		
		while (tempValue > 0) {
			int charValue = ((tempValue - 1) % 26);
			sb.append((char)(charValue + 65));
			tempValue = (tempValue - charValue) / 26;
		}
		return sb.reverse().toString();
	}
}
