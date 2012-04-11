/**
 *  Apr 11, 2012
 */
package ravid.java.programs.mongo.translate;

import org.joda.time.DateTime;

import ravid.java.programs.mongo.model.User;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 * Translate the given User object into DBObject and vice-versa.
 *
 * @author Ravi
 */
public class UserToDBObject {

	public static DBObject translateToDBObject(User user) {
		DBObject dbObject = new BasicDBObject("_id", user.getUserId());
		
		dbObject.put(User.UserFieldNames.email.toString(), user.getEmail());
		dbObject.put(User.UserFieldNames.isMale.toString(), user.getSex());
		dbObject.put(User.UserFieldNames.birthday.toString(), user.getBirthday().toString());
		
		return dbObject;
	}
	
	public static User translateToUser(DBObject dbObject) {
		if (null == dbObject) {
			return null;
		}
		User user = new User((String)dbObject.get("_id"), 
				(String)dbObject.get(User.UserFieldNames.email.toString()), 
				(String)dbObject.get(User.UserFieldNames.isMale.toString()), 
				new DateTime(dbObject.get(User.UserFieldNames.birthday.toString())));
				
		return user;		
	}
}
