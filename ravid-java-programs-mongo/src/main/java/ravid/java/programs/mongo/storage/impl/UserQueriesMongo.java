/**
 *  Apr 11, 2012
 */
package ravid.java.programs.mongo.storage.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ravid.java.programs.mongo.core.MongoConnectionHandler;
import ravid.java.programs.mongo.model.User;
import ravid.java.programs.mongo.storage.UserQueries;
import ravid.java.programs.mongo.translate.UserToDBObject;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

/**
 * Implementation class for {@link UserQueries} to perform queries against Mongo
 * collection for {@link User}
 * 
 * @author Ravi
 */
@Component
public class UserQueriesMongo implements UserQueries {

	@Autowired
	private MongoConnectionHandler handler;
	private String COLLECTION_NAME = User.class.getSimpleName();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ravid.java.programs.mongo.storage.UserQueries#get(ravid.java.programs
	 * .mongo.model.User)
	 */
	public User get(User user) {
		DBObject query = new BasicDBObject("_id", user.getUserId());

		return UserToDBObject.translateToUser(handler.getCollection(COLLECTION_NAME).findOne(query));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ravid.java.programs.mongo.storage.UserQueries#getAll()
	 */
	public List<User> getAll() {
		List<User> users = new ArrayList<User>();
		DBCursor cursor = handler.getCollection(COLLECTION_NAME).find();
		while (cursor.hasNext()) {
			User user = UserToDBObject.translateToUser(cursor.next());
			if (null != user) {
				users.add(user);
			}
		}
		return users;
	}

	/* (non-Javadoc)
	 * @see ravid.java.programs.mongo.storage.UserQueries#get(java.lang.String)
	 */
	public User get(String userId) {
		DBObject query = new BasicDBObject("_id", userId);

		return UserToDBObject.translateToUser(handler.getCollection(COLLECTION_NAME).findOne(query));
	}

}
