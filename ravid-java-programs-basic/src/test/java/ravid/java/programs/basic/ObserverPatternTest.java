/**
 *  Apr 20, 2012
 */
package ravid.java.programs.basic;

import junit.framework.TestCase;

/**
 * Test suite for {@link ObserverPattern}
 *
 * @author Ravi
 */
public class ObserverPatternTest extends TestCase {

	public void testObserverPattern() {
		Thread observerPattern = new Thread(new ObserverPattern());
		observerPattern.run();
	}
}
