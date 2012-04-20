/**
 *  Apr 17, 2012
 */
package ravid.java.programs.basic;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Test suite for {@link ExactChangeProblem}
 *
 * @author Ravi
 */
public class ExactChangeProblemTest extends TestCase {
	
	/**
	 * Test method for {@link ravid.java.programs.basic.ExactChangeProblem#getChange(int)}.
	 */
	public final void testGetChangeNoDimesNickles() {
		ExactChangeProblem exProblem = new ExactChangeProblem(10, 10, 10, 0, 0);
		
		int[] actual = exProblem.getChange(30);
		Assert.assertTrue(actual.length == 5);
		int[] expected = {0, 0, 3, 0, 0};
		for (int i = 0; i < actual.length; i++) {
			Assert.assertEquals(expected[i], actual[i]);
		}
		display(actual);
	}

	/**
	 * Test method for {@link ravid.java.programs.basic.ExactChangeProblem#getChange(int)}.
	 */
	public final void testGetChangeYesAll() {
		ExactChangeProblem exProblem = new ExactChangeProblem(10, 10, 10, 10, 10);
		
		int[] actual = exProblem.getChange(169);
		Assert.assertTrue(actual.length == 5);
		int[] expected = {1, 2, 1, 1, 4};
		for (int i = 0; i < actual.length; i++) {
			Assert.assertEquals(expected[i], actual[i]);
		}
		display(actual);
	}

	/**
	 * Test method for {@link ravid.java.programs.basic.ExactChangeProblem#getChange(int)}.
	 */
	public final void testGetChangeNoDollars() {
		ExactChangeProblem exProblem = new ExactChangeProblem(0, 10, 10, 10, 10);
		
		int[] actual = exProblem.getChange(169);
		Assert.assertTrue(actual.length == 5);
		int[] expected = {0, 6, 1, 1, 4};
		for (int i = 0; i < actual.length; i++) {
			Assert.assertEquals(expected[i], actual[i]);
		}
		display(actual);
	}

	private void display(int[] actual) {
		String[] amountName = {"dollars", "quarters", "dimes", "nickle", "cents"};
		
		for (int i = 0; i < actual.length; i++) {
			System.out.print(actual[i] + " " + amountName[i]);
			if (i != actual.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("");
	}
}
