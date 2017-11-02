package kwaymergesort;

import timing.Ticker;

public class KWayMergeSort {

	/**
	 * @param K
	 *            some positive power of 2.
	 * @param input
	 *            an array of unsorted integers. Its size is either 1, or some other
	 *            power of 2 that is at least K
	 * @param ticker
	 *            call .tick() on this to account for the work you do
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
		int split = n / K;
		ticker.tick(2);
		if (n > 1) {
			Integer[][] splitArray = new Integer[K][split];
			ticker.tick(1 + n);

			for (int i = 0; i < K; i++) {
				ticker.tick();
				for (int j = 0; j < n / K; j++) {
					int inputValue = i * split;
					splitArray[i][j] = input[j + inputValue];
					ticker.tick(2);
				}
			}
			int l = 0;
			ticker.tick();
			while (l < K) {
				// now we have to split it K times
				splitArray[l] = kwaymergesort(K, splitArray[l], ticker);
				l++;
				ticker.tick(2);
			}
			return recursiveKwaymergesort(splitArray, ticker)[0];
			// return input for now until i make teh function above
			// return input;
		} else {
			ticker.tick();
			// no need to sort anything if there is only 1 item in kway
			return input;
		}
	}

	public static Integer[][] recursiveKwaymergesort(Integer[][] in, Ticker ticker) {
		// low goes forward in the array
		int low = in[0].length;
		// high goes backward in the array
		int high = in.length;
		// if we have more than 1 entry, merge the arrays.
		if (high > 1) {
			Integer[] oddAr = new Integer[low];
			Integer[] evenAr = new Integer[low];
			int halfHigh = high / 2;
			// gotta make a new array to fit the old sorted, merged arrays into
			Integer[][] mergedArrays = new Integer[halfHigh][2 * low];
			ticker.tick();

			int i = 0;
			while (i < halfHigh) {
				oddAr = in[i * 2 + 1];
				evenAr = in[i * 2];
				// make a temporary Array that is the length of even and odd Arrays,
				// so we can sort the values
				Integer[] tempArray = new Integer[evenAr.length + oddAr.length];
				// have to keep track of how far we are in each array
				int tempLoop = 0;
				int oddArLoop = 0;
				int evenArLoop = 0;
				ticker.tick(6 + (8 * i));
				// first while loop is for putting the arrays together in a sorted fashion
				// store sorted values in the tempArray
				while (oddArLoop < oddAr.length && evenArLoop < evenAr.length) {
					// if oddAr value is more, then we wanna take the lower value from evenAr and
					// put it in tempArray
					if (oddAr[oddArLoop] > evenAr[evenArLoop]) {
						tempArray[tempLoop] = evenAr[evenArLoop];
						evenArLoop++;
						ticker.tick(3);
						// vice versa
					} else if (oddAr[oddArLoop] < evenAr[evenArLoop]) {
						tempArray[tempLoop] = oddAr[oddArLoop];
						oddArLoop++;
						ticker.tick(3);
					}
					tempLoop++;
					ticker.tick(2);
				}
				// if we have an extra odd or even ithem then we take it
				// and we put it in the temp Array
				while (oddAr.length > oddArLoop || evenAr.length > evenArLoop) {
					if (oddAr.length > oddArLoop) {
						tempArray[tempLoop] = oddAr[oddArLoop];
						oddArLoop++;
					} else if (evenAr.length > evenArLoop) {
						tempArray[tempLoop] = evenAr[evenArLoop];
						evenArLoop++;
					}
					tempLoop++;
					ticker.tick(4);
				}
				// put all the temp values in our final Merged Array
				mergedArrays[i] = tempArray;
				ticker.tick();
				i++;
			}
			// repeat until sorted and merged completely. keep track of ticks.
			return recursiveKwaymergesort(mergedArrays, ticker);

			// if the array only has 1 entry, then we stop.
		} else {
			return in;
		}
		// tick tock tick tock
	}
}
