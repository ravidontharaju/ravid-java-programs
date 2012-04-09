/**
 *  Apr 5, 2012
 */
package ravid.java.programs.basic;

/**
 * Finding the largest sum in sub arrays.
 *
 * @author Ravi
 */
public class LargestSubArray {
	
	/**
	 * Find the largest sum for the sub arrays.
	 * 
	 * @param array
	 * @return the largest sum.
	 */
	public static int largestSubArraySum(int[] array) {
		int currentSum;
		int maxSum;
		currentSum = maxSum = 0;
		
		for (int i = 0; i < array.length; i++) {
			currentSum += array[i];
			if (currentSum >= maxSum) {
				maxSum = currentSum;
			} 
			if (currentSum <= 0) {
				currentSum = 0;
			}
		}
		return maxSum;
	}
}
