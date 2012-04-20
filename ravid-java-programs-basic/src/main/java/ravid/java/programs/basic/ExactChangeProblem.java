/**
 *  Apr 17, 2012
 */
package ravid.java.programs.basic;

import java.util.ArrayList;
import java.util.List;

/**
 * Giving out exact change.
 *
 * @author Ravi
 */
public class ExactChangeProblem {

	private int dollarsAvailable;
	private int quartersAvailable;
	private int dimesAvailable;
	private int nicklesAvailable;
	private int centsAvailable;
	
	private final List<int[]> COMBINATIONS = new ArrayList<int[]>();
	
	public ExactChangeProblem(int dollars, int quarters, int dimes,
			int nickles, int cents) {
		this.dollarsAvailable = dollars;
		this.quartersAvailable = quarters;
		this.dimesAvailable = dimes;
		this.nicklesAvailable = nickles;
		this.centsAvailable = cents;
	}
	
	public int[] getChange(int cents) {
		
		int[] change = new int[5];
		int[] denominations = {100, 25, 10, 5, 1};
		
		COMBINATIONS.add(change);
		int originalVal = cents;
		int currentVal = 0;
		
		boolean changeMade = false;
		
		for (int i = 0; i < change.length; i++) {
			if (cents >= denominations[i]) {
				
				int chg = cents / denominations[i];
				int diff = getCoinsRemaining(denominations[i]) - chg;
		
				
				if (diff > 0) {
					int index = COMBINATIONS.size() - 2;
					int tempVal = (index < 0) ? 0 : COMBINATIONS.get(index)[i];
					if (COMBINATIONS.size() > 1 && !changeMade && 
							tempVal > 0) {
						change[i] = tempVal - 1;
						changeMade = true;
					} else {
						change[i] = chg;
					}
				} else {
					change[i] = getCoinsRemaining(denominations[i]);
				}
				cents -= change[i] * denominations[i];
				currentVal += change[i] * denominations[i];
			}
		}
		
		if (currentVal != originalVal && COMBINATIONS.size() <= 10 ) { //10 is just a ball park figure to avoid stack overflow
			return getChange(originalVal);
		}
		return change;
	}
	
	public int getCoinsRemaining(int denomination) {
		int retVal = 0;
		switch(denomination) {
		case 100:
			retVal = getDollarsAvailable();
			break;
		case 25:
			retVal = getQuartersAvailable();
			break;
		case 10:
			retVal = getDimesAvailable();
			break;
		case 5:
			retVal = getNicklesAvailable();
			break;
		case 1:
			retVal = getCentsAvailable();
			break;
		default:
			retVal = 0;
		}
		return retVal;
	}
	
	/**
	 * @return the centsAvailable
	 */
	public int getCentsAvailable() {
		return centsAvailable;
	}
	
	/**
	 * @return the dimesAvailable
	 */
	public int getDimesAvailable() {
		return dimesAvailable;
	}
	
	/**
	 * @return the dollarsAvailable
	 */
	public int getDollarsAvailable() {
		return dollarsAvailable;
	}
	
	/**
	 * @return the nicklesAvailable
	 */
	public int getNicklesAvailable() {
		return nicklesAvailable;
	}
	
	/**
	 * @return the quartersAvailable
	 */
	public int getQuartersAvailable() {
		return quartersAvailable;
	}
	
}
