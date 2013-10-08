package frenchFlagProblem;

public class FlagProblem {
	/**
	 * Precondition: unsorted contains only capital Rs, Ws, and Bs
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
