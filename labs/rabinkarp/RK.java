package rabinkarp;

//http://www.cs.wustl.edu/~cytron/247Pages/f17/Modules/9/lab.html
public class RK {

	//
	// Be sure to look at the write up for this assignment
	// so that you get full credit by satisfying all
	// of its requirements
	//

	// FOR FULL CREDIT:
	// -your approach must take less than omega(m) time.
	// -Produce the correct hash results using an incremental approach
	// -Ensure that the above computation does not cause overflow, taking care to
	// keep the numbers mod 511 wherever possible
	// -Use space proportional only to m, which is the size of the sliding window.
	// -Implement a circular buffer as described in class, of size m, to keep track
	// of the last m characters seen.

	/**
	 * Rabin-Karp string matching for a window of the specified size
	 * 
	 * @param m
	 *            size of the window
	 */
	int size;
	int index = 0;
	int hashSlingingSlasher = 0;
	int constant;
	char[] charArray;

	public RK(int m) {
		charArray = new char[m];
		size = m;
		//he was number one!
		int number = 1;
		
		for (int i = 0; i < m; i++) {
			number = (31 * number) % 511;
		}
		
		constant = number;
	}

	/**
	 * Compute the rolling hash for the previous m-1 characters with d appended.
	 * 
	 * @param d
	 *            the next character in the target string
	 * @return
	 */

	public int nextCh(char d) {
		int rollingIndex = charArray[index % size];
		if (index >= size) {
			charArray[index % size] = d;
			// from formula in class
			hashSlingingSlasher = (hashSlingingSlasher * 31 - constant * rollingIndex + d) % 511;
		}
		if (index < size) {
			charArray[index] = d;
			hashSlingingSlasher = (hashSlingingSlasher * 31 + d) % 511;
		}
		// move to next char
		index++;
		// System.out.print(numCurrent);
		if (hashSlingingSlasher < 0) {
			hashSlingingSlasher = hashSlingingSlasher + 511;
		}
		return hashSlingingSlasher;
	}

}
