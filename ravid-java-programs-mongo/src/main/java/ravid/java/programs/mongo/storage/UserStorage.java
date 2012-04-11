/**
 *  Apr 11, 2012
 */
package ravid.java.programs.mongo.storage;

import ravid.java.programs.mongo.model.User;

/**
 * Methods to perform create, update, delete operations.
 *
 * @author Ravi
 */
public interface UserStorage {

	/**
	 * Save a product into User table.
	 * @param user
	 */
	public void save(User user);
	
	/**
	 * Update existing product in User table.
	 * @param user
	 */
	public void update(User user);
	
	/**
	 * Delete product from User table.
	 * @param user
	 */
	public void delete(User user);
}
