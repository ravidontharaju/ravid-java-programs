/**
 *  Apr 5, 2012
 */
package ravid.java.programs.basic;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Test suite for {@link LargestSubArray}
 *
 * @author Ravi
 */
public class LargestSubArrayTest extends TestCase {

	
	/**
	 * Test method for {@link ravid.java.programs.basic.LargestSubArray#largestSubArraySum(int[])}.
	 */
	public final void testLargestSubArraySum() {
		int[] input = {-1, -11, 1, -6, -5};
		Assert.assertEquals(1, LargestSubArray.largestSubArraySum(input));
	}

}
