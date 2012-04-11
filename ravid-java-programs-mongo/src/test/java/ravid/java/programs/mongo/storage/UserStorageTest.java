/**
 *  Apr 11, 2012
 */
package ravid.java.programs.mongo.storage;

import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import ravid.java.programs.config.SpringConfigApp;
import ravid.java.programs.mongo.model.User;

/**
 * Test suite for {@link UserStorage}
 *
 * @author Ravi
 */
public class UserStorageTest {

	private UserStorage storage;

	@Before
	public void setUp() {
		storage = SpringConfigApp.getUserStorage();
	}
	
	/**
	 * Test method for {@link ravid.java.programs.mongo.storage.UserStorage#save(ravid.java.programs.mongo.model.User)}.
	 */
	@Test
	public final void testSave() {
		DateTime birthday = new DateTime(1982, 12, 17, 19, 27);
		
		User user = new User("ravi.dontharaju", "ravi.dontharaju@gmail.com", "Male", birthday);
		storage.save(user);
	}

	/**
	 * Test method for {@link ravid.java.programs.mongo.storage.UserStorage#update(ravid.java.programs.mongo.model.User)}.
	 */
	@Test
	public final void testUpdate() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link ravid.java.programs.mongo.storage.UserStorage#delete(ravid.java.programs.mongo.model.User)}.
	 */
	@Test
	public final void testDelete() {
		fail("Not yet implemented"); // TODO
	}

}
