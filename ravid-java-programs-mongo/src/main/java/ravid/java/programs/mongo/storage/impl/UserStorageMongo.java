/**
 *  Apr 11, 2012
 */
package ravid.java.programs.mongo.storage.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ravid.java.programs.mongo.core.MongoConnectionHandler;
import ravid.java.programs.mongo.model.User;
import ravid.java.programs.mongo.storage.UserStorage;
import ravid.java.programs.mongo.translate.UserToDBObject;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 * Implementation class for {@link UserStorage} to perform create, update and delete
 * for {@link User} on MongoDB.
 *
 * @author Ravi
 */
@Component
public class UserStorageMongo implements UserStorage {
	
	@Autowired
	private MongoConnectionHandler handler;
	private final String COLLECTION_NAME = User.class.getSimpleName();
	
	/* (non-Javadoc)
	 * @see ravid.java.programs.mongo.storage.UserStorage#save(ravid.java.programs.mongo.model.User)
	 */
	public void save(User user) {
		DBObject insert = UserToDBObject.translateToDBObject(user);
		
		handler.getCollection(COLLECTION_NAME).save(insert);
	}

	/* (non-Javadoc)
	 * @see ravid.java.programs.mongo.storage.UserStorage#update(ravid.java.programs.mongo.model.User)
	 */
	public void update(User user) {
		DBObject query = new BasicDBObject("_id", user.getUserId());
		DBObject replace = UserToDBObject.translateToDBObject(user);
		
		handler.getCollection(COLLECTION_NAME).update(query, replace, true, false);
	}

	/* (non-Javadoc)
	 * @see ravid.java.programs.mongo.storage.UserStorage#delete(ravid.java.programs.mongo.model.User)
	 */
	public void delete(User user) {
		DBObject query = new BasicDBObject("_id", user.getUserId());
		
		handler.getCollection(COLLECTION_NAME).remove(query);
	}

}
