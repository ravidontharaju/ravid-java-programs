/**
 *  Apr 8, 2012
 */
package ravid.java.programs.mongo.core;


import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ravid.java.programs.config.SpringConfigApp;

/**
 * Test suite for {@link MongoConnectionHandlerTest}
 *
 * @author Ravi
 */
public class MongoConnectionHandlerTest extends TestCase {

	private MongoConnectionHandler handler;

	@Before
	public void setUp() {
		handler = SpringConfigApp.getMongoConnectionHandler();
	}

	@Test
	public void test() {
		Assert.assertNotNull(handler.getDB());
	}
}
