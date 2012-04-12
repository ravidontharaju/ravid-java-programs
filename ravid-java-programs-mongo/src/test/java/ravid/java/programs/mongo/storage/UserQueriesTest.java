/**
 *  Apr 11, 2012
 */
package ravid.java.programs.mongo.storage;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ravid.java.programs.config.SpringConfigApp;
import ravid.java.programs.mongo.model.User;
import ravid.java.programs.mongo.storage.impl.UserQueriesMongo;

/**
 * Test suite for {@link UserQueries}
 *
 * @author Ravi
 */
public class UserQueriesTest {

	private UserQueries queries;

	@Before
	public void setUp() {
		queries = (UserQueriesMongo)SpringConfigApp.getBean("userQueriesMongo");
	}
	/**
	 * Test method for {@link ravid.java.programs.mongo.storage.UserQueries#get(ravid.java.programs.mongo.model.User)}.
	 */
	@Test
	public final void testGet() {
		User user = queries.get("ravi.dontharaju");
		String expected = "ravi.dontharaju@gmail.com";
		String actual = user.getEmail();
		
		Assert.assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link ravid.java.programs.mongo.storage.UserQueries#getAll()}.
	 */
	@Test
	public final void testGetAll() {
		List<User> users = queries.getAll();
		
		int expected = 1;
		int actual = users.size();
		
		Assert.assertEquals(expected, actual);
	}

}
