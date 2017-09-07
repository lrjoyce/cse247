package studio0.growinglist;

import timing.ExecuteAlgorithm;
import timing.utils.GenSizes;
import timing.utils.IntArrayGenerator;

public class OurGrowth1 extends Rarrays {
	//grow by 10% of previous size, min 1
	
	
	
	public int getNewSize() {
		//throw new Error("You must implement this function");
		if (array.length < 15) {
			// .1 * 14 is 1.4 which is rounded down to 1
			return array.length +1;
		}else {
			//take 10% of old array, round it, convert that to an int
			int extraArrayLength = (int) Math.round(0.1 * array.length) ;
		return array.length + extraArrayLength;
		}
	}
	
	public String toString() { return "Grow by our own function (1)"; }

	public static void main(String[] args) {
		GenSizes sizes = GenSizes.arithmetic(1, 1000, 1);
		ExecuteAlgorithm.timeAlgorithm(
				"growth1", 
				"studio0.growinglist.OurGrowth1", 
				new IntArrayGenerator(), 
				sizes
				);	
	}

}
