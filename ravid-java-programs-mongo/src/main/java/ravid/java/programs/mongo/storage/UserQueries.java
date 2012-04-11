/**
 *  Apr 11, 2012
 */
package ravid.java.programs.mongo.storage;

import java.util.List;

import ravid.java.programs.mongo.model.User;

/**
 * Query operations on {@link User} data.
 *
 * @author Ravi
 */
public interface UserQueries {

	/**
	 * Look up the given user.
	 * 
	 * @param user
	 * @return
	 */
	public User get(String userId);
	
	/**
	 * Look up the given user.
	 * 
	 * @param user
	 * @return
	 */
	public User get(User user);
	
	/**
	 * Return all users.
	 * 
	 * @return
	 */
	public List<User> getAll();
}
