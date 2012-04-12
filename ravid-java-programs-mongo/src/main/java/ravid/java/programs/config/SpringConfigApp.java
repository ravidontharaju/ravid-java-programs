/**
 *  Apr 11, 2012
 */
package ravid.java.programs.config;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Initialize the various spring components required.
 * 
 * @author Ravi
 */
public final class SpringConfigApp {

	private static ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
			new String[] { "ravid/java/programs/mongo/config/applicationContext-MongoDB.xml" });

	//Don't want anyone to create an instance even by mistake.
	private SpringConfigApp() { }
	
	public static Object getBean(String name) {
		return ctx.getBean(name);
	}
	
}
