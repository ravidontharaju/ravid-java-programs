/**
 *  Apr 2, 2012
 */
package ravid.java.programs.basic;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Test suite fr {@link StringReversal}
 *
 * @author Ravi
 */
public class StringReversalTest extends TestCase {

	private StringReversal sReversal = new StringReversal();
	/**
	 * Test method for {@link ravid.java.programs.basic.StringReversal#reverseWord(java.lang.String)}.
	 */
	public final void testReverseWord() {
		Assert.assertEquals("hello", sReversal.reverseWord("olleh"));
		Assert.assertEquals("helo", sReversal.reverseWord("oleh"));
		Assert.assertEquals("", sReversal.reverseWord(""));
	}

	/**
	 * Test method for {@link ravid.java.programs.basic.StringReversal#reverseLine(java.lang.String)}.
	 */
	public final void testReverseLine() {
		Assert.assertEquals("world hello", sReversal.reverseLine("hello world"));
		Assert.assertEquals("testing world hello", sReversal.reverseLine("hello world testing"));
		Assert.assertEquals(" ", sReversal.reverseLine(" "));
	}

}
