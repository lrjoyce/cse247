package kwaymergesort;

import timing.Ticker;

public class KWayMergeSort {

	/**
	 * @param K some positive power of 2.
	 * @param input an array of unsorted integers.  Its size is either 1, or some other power of 2 that is at least K
	 * @param ticker call .tick() on this to account for the work you do
	 * @return
	 */
	// Following just copies the input as the answer
	//
	// You must replace the loop below with code that performs
	// a K-way merge sort, placing the result in ans
	//
	// The web page for this assignment provides more detail.
	//
	// Use the ticker as you normally would, to account for
	// the operations taken to perform the K-way merge sort.
	
	public static Integer[] kwaymergesort(int K, Integer[] input, Ticker ticker) {
		int n = input.length;
		int split = n/K;
		ticker.tick(2);
		if(n>1){
			Integer[][] splitArray = new Integer[K][split];
			ticker.tick(1+n);
			for (int i=0; i<K; i++) {
				ticker.tick();
				for (int j=0; j<n/K; j++) {
					int inputValue = i*split;
					splitArray[i][j] = input[j+inputValue];
					ticker.tick(2);
				}
			}
			int i=0;
			ticker.tick();
			while(i<K) {
				splitArray[i]=kwaymergesort(K, splitArray[i], ticker);
				i++;
				ticker.tick(2);
			}
			return recursiveKwaymergesort(splitArray, ticker)[0];
			//return input for now until i make teh function above
			//return input;
		}else {
			ticker.tick();
			//no need to sort anything if there is only 1 item in kway
			return input;
		}
	}
	
	public static Integer[] recursiveKwaymergesort(){
		return null;
	}
}
	
	
