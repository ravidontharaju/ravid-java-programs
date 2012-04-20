/**
 *  Apr 20, 2012
 */
package ravid.java.programs.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * A basic test implementation of Observer pattern.
 *
 * @author Ravi
 */
public class ObserverPattern implements Runnable {

	public void run() {
		ProcessA a = new ProcessA();
		ProcessB b = new ProcessB();
		
		ProcessGroup group = new ProcessGroup();
		group.addObserver(a);
		group.addObserver(b);
		
		group.setState("my new state");
	}
}

class ProcessGroup extends Observable {
	
	private String state;
	private List<Observer> list = new ArrayList<Observer>();
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
		notifyObservers();
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	
	/* (non-Javadoc)
	 * @see java.util.Observable#addObserver(java.util.Observer)
	 */
	@Override
	public synchronized void addObserver(Observer o) {
		list.add(o);
	}
	
	/* (non-Javadoc)
	 * @see java.util.Observable#notifyObservers()
	 */
	@Override
	public void notifyObservers() {
		for (Observer observer : list) {
			observer.update(this, state);
		}
	}
}

class ProcessA implements Observer {

	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(Observable o, Object arg) {
		System.out.println("In A : " + arg);
	}
}

class ProcessB implements Observer {

	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(Observable o, Object arg) {
		System.out.println("In B : " + arg);
	}
}

