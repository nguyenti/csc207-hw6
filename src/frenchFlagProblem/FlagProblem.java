package frenchFlagProblem;

/**
 * Class that contains a method that sorts an array of 'R', 'W', and 'B's
 * 
 * @author Mark Lewis
 * @author Tiffany Nguyen
 * @author Daniel Goldstein
 */

public class FlagProblem {
	/**
	 * Precondition: unsorted contains only capital Rs, Ws, and Bs
	 * 
	 * Postcondition: All 'R's from unsorted are in the beginning of the array followed by all the
	 * 	'W's then all of the 'B's are at the end.
	 */
	public static char[] sortFlag(char[] unsorted) {
		// need to keep track of boundaries
		// red and blue boundary is currentR

		int currentR = 0;
		int currentB = unsorted.length - 1;
		for (int i = 0; i <= currentB; i++) {
			if (unsorted[i] == 'R') {
				char temp = unsorted[currentR];
				unsorted[currentR] = unsorted[i];
				unsorted[i] = temp;
				currentR++;
			} // if
			else if (unsorted[i] == 'B') {
				char temp = unsorted[currentB];
				unsorted[currentB] = unsorted[i];
				unsorted[i] = temp;
				currentB--;
				/**
				 * need to examine element put into the ith position still only
				 * goes through array once, as currentB--; so i must be one less
				 */
				i--;
			} // else if
		}
		return unsorted;
	} // sortFlag
}
