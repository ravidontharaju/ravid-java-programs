/**
 *  Copyright Ravi Dontharaju :)
 */
package ravid.java.programs.basic;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Test suite for {@link Palindrome}
 *
 * @author Ravi
 */
public class PalindromeTest extends TestCase {

	private Palindrome palindrome = new Palindrome();
	
	/**
	 * Test method for {@link ravid.java.programs.basic.Palindrome#checkForPalindrome(java.lang.String)}.
	 */
	public final void testCheckForPalindrome() {
		Assert.assertTrue(palindrome.checkForPalindrome("test1tset"));
		Assert.assertFalse(palindrome.checkForPalindrome("test"));
		Assert.assertFalse(palindrome.checkForPalindrome(""));
		Assert.assertFalse(palindrome.checkForPalindrome(null));
	}
}
