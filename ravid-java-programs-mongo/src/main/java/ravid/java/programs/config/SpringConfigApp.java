/**
 *  Apr 11, 2012
 */
package ravid.java.programs.config;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import ravid.java.programs.mongo.core.MongoConnectionHandler;
import ravid.java.programs.mongo.storage.UserQueries;
import ravid.java.programs.mongo.storage.UserStorage;
import ravid.java.programs.mongo.storage.impl.UserQueriesMongo;
import ravid.java.programs.mongo.storage.impl.UserStorageMongo;

/**
 * Initialize the various components required.
 * 
 * @author Ravi
 */
public final class SpringConfigApp {

	private MongoConnectionHandler handler;
	private UserStorage storage;
	private UserQueries queries;
	
	private static final SpringConfigApp SPRING_CONFIG_APP = new SpringConfigApp();
	
	private SpringConfigApp() { 
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				new String[] { "ravid/java/programs/mongo/core/applicationContext-MongoDB.xml" });
		handler = (MongoConnectionHandler) ctx.getBean(MongoConnectionHandler.class);
		storage = (UserStorageMongo) ctx.getBean(UserStorageMongo.class);
		queries = (UserQueriesMongo) ctx.getBean(UserQueriesMongo.class);
	}
	
	public static MongoConnectionHandler getMongoConnectionHandler() {
		return SPRING_CONFIG_APP.handler;
	}
	
	public static UserStorage getUserStorage() {
		return SPRING_CONFIG_APP.storage;
	}
	
	public static UserQueries getUserQueries() {
		return SPRING_CONFIG_APP.queries;
	}
}
