/**
 *  Apr 13, 2012
 */
package ravid.java.programs.basex;

import java.util.List;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ravid.java.programs.config.SpringConfigApp;

/**
 * Test suite for {@link BasicQueries}
 * 
 * @author Ravi
 */
public class BasicQueriesTest extends TestCase {

	private BasicQueries basicQueries;

	@Before
	public void setUp() {
		basicQueries = (BasicQueries) SpringConfigApp.getBean("basicQueries");
	}

	@Test
	public void test() {
		Assert.assertNotNull(basicQueries);
	}

	/**
	 * Test method for {@link ravid.java.programs.basex.BasicQueries#getListForItem()}.
	 */
	@Test
	public final void testIterate() {
		List<String> listForItem = basicQueries.getListForItem("//country/name/text()");
		Assert.assertTrue(listForItem.size() >= 1);
	}

}
