/**
 *  Apr 2, 2012
 */
package ravid.java.programs.basic;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Test suite for {@link StringToInteger}
 *
 * @author Ravi
 */
public class StringToIntegerTest extends TestCase {

	private StringToInteger sToI = new StringToInteger();

	/**
	 * Test method for {@link ravid.java.programs.basic.StringToInteger#atoi(java.lang.String)}.
	 */
	public final void testAtoi() {
		Assert.assertTrue(sToI.atoi("-180") == -180);
		Assert.assertTrue(sToI.atoi("90") == 90);
		Assert.assertTrue(sToI.atoi("-") == -1);
		Assert.assertTrue(sToI.atoi(" ") == -1);
		Assert.assertTrue(sToI.atoi(null) == -1);
	}

}
