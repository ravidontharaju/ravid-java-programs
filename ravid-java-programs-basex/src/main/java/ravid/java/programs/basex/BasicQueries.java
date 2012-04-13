/**
 *  Apr 12, 2012
 */
package ravid.java.programs.basex;

import java.util.List;

import org.basex.core.Context;
import org.basex.query.QueryException;
import org.basex.query.QueryProcessor;
import org.basex.query.item.Item;
import org.basex.query.iter.Iter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;


/**
 * Sample app to run basic BaseX queries.
 *
 * @author Ravi
 */
@Component
public class BasicQueries {

	@Autowired
	@Qualifier("context")
	private Context context;
	
	@Autowired
	@Qualifier("filePath")
	private String filePath;

	private String currentDir = System.getProperty("user.dir").replace('\\', '/');
	
	public List<String> getListForItem(String item) {

		QueryProcessor queryProcessor = null;
		List<String> list = Lists.newArrayList();

		try {
			filePath = currentDir + "/" + filePath;
			String query =
				"for $x in doc('" + filePath + "')" + item + " return data($x)";

			queryProcessor = new QueryProcessor(query, context);

			Iter iterator;
			iterator = queryProcessor.iter();
			Item eachItem;
			
			while ((eachItem = iterator.next()) != null) {
				list.add((String)eachItem.toJava());
			}

			queryProcessor.close();
		} catch (QueryException e) {
			e.printStackTrace();
		}
		return list;
	}

}
