/**
 *  
 */
package ravid.java.programs.basic;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Test suite for {@link Anagrams}
 *
 * @author Ravi
 */
public class AnagramsTest extends TestCase {

	private Anagrams anagrams = new Anagrams();
	
	/**
	 * Test method for {@link ravid.java.programs.basic.Anagrams#checkForAnagram(java.lang.String, java.lang.String)}.
	 */
	public final void testCheckForAnagram() {
		Assert.assertTrue(anagrams.checkForAnagram("((ana%)gram)2", "(2)gra()mana%"));
		Assert.assertFalse(anagrams.checkForAnagram("((ana%)gram)1", "(2)gra()mana%"));
		Assert.assertFalse(anagrams.checkForAnagram(null, "(2)gra()mana%"));
		Assert.assertFalse(anagrams.checkForAnagram("empty", "(2)gra()mana%"));
	}
}
