/**
 *  Apr 8, 2012
 */
package ravid.java.programs.basic;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Test suite for {@link LinkedListOperations}
 *
 * @author Ravi
 */
public class LinkedListOperationsTest extends TestCase {

	private LinkedListOperations nthFromLast;
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		nthFromLast = new LinkedListOperations();
	}
	
	private void insert(int n) {
		for (int i = 1; i <= n; i++) {
			nthFromLast.push("value" + i);
		}
	}

	/**
	 * Test method for {@link ravid.java.programs.basic.LinkedListOperations#traverse()}.
	 */
	public final void testTraverse() {
		insert(5);
		String[] array = nthFromLast.traverse();
		Assert.assertNotNull(array);
		Assert.assertEquals(5, array.length);
		
		for (String str : array) {
			System.out.println(str);
		}
	}

	/**
	 * Test method for {@link ravid.java.programs.basic.LinkedListOperations#size()}.
	 */
	public final void testSize() {
		Assert.assertEquals(0, nthFromLast.size());
		insert(3);
		Assert.assertEquals(3, nthFromLast.size());

	}

	/**
	 * Test method for {@link ravid.java.programs.basic.LinkedListOperations#getN(int)}.
	 */
	public final void testGetN() {
		insert(6);
		String actual = nthFromLast.getN(5);
		String expected = "value5";
		
		Assert.assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link ravid.java.programs.basic.LinkedListOperations#getNFromLast(int)}.
	 */
	public final void testGetNFromLast() {
		insert(10);
		String actual = nthFromLast.getNFromLast(10);
		String expected = "value1";
		
		Assert.assertEquals(expected, actual);
	}

}
