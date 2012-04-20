/**
 *  Apr 8, 2012
 */
package ravid.java.programs.mongo.core;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.MongoOptions;

/**
 * Connection Handler for MongoDB
 *
 * @author Ravi
 */
@SuppressWarnings("restriction")
@Component
public class MongoConnectionHandler {

	private static final Logger LOGGER = Logger.getLogger(MongoConnectionHandler.class);
	
	@Value("${database}")
	private String database;

	@Autowired
    private Mongo mongo;
	
    private DB db;
    
    /**
     * Initiates a mongo connection post construct.
     */
    @SuppressWarnings({ "unused" })
	@PostConstruct
    private void initiateMongoConnection() {
        try {
            MongoOptions mongoOptions = mongo.getMongoOptions();
            
            mongoOptions.socketKeepAlive = true;
            mongoOptions.autoConnectRetry = true;
            mongoOptions.socketTimeout = 3000; // 3seconds
            mongoOptions.connectTimeout = 3000; // 3seconds
            mongoOptions.maxWaitTime = 3000; //3seconds
            mongoOptions.maxAutoConnectRetryTime = 3000; //3seconds
            mongoOptions.connectionsPerHost = 10;
            mongoOptions.w = -1;
            
        } catch (MongoException e) {
            throw new RuntimeException("Error creating mongo object", e);
        }
        if (null == mongo) {
            throw new RuntimeException("Error creating mongo object, mongo object was null");
        }
        db = mongo.getDB(database);
        LOGGER.info("Mongo connection successfully established");
    }
    
    /**
     * Return Mongo DB Object.
     * 
     * @return
     */
    public DB getDB() {
    	return db;
    }
    
    /**
     * Returns the associated DBCollection with the parameter in our default database.
     *  
     * @param collectionName
     * @return
     */
    public DBCollection getCollection(String collectionName) {
    	return db.getCollection(collectionName);
    }
    
}
