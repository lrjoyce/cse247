package rabinkarp;
//http://www.cs.wustl.edu/~cytron/247Pages/f17/Modules/9/lab.html
public class RK {
	
	//
	// Be sure to look at the write up for this assignment
	//  so that you get full credit by satisfying all
	//  of its requirements
	//
	

	/**
	 * Rabin-Karp string matching for a window of the specified size
	 * @param m size of the window
	 */
	public RK(int m) {

	}
	

	/**
	 * Compute the rolling hash for the previous m-1 characters with d appended.
	 * @param d the next character in the target string
	 * @return
	 */
	
	//FOR FULL CREDIT:
	//-your approach must take less than omega(m) time.
	//-Produce the correct hash results using an incremental approach
	//-Ensure that the above computation does not cause overflow, taking care to keep the numbers mod 511 wherever possible
	//-Use space proportional only to m, which is the size of the sliding window.
	//-Implement a circular buffer as described in class, of size m, to keep track of the last m characters seen.
	public int nextCh(char d) {
		return 0;
	}

}
