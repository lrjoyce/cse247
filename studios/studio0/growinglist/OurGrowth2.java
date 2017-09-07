package studio0.growinglist;

import timing.ExecuteAlgorithm;
import timing.utils.GenSizes;
import timing.utils.IntArrayGenerator;

public class OurGrowth2 extends Rarrays {

	/**
	 * Try some function you think will work here.
	 * increase the array by 20 cells each time it fills.
	 */
	public int getNewSize() {
		System.out.println(array.length);
		return array.length + 20;
	}
	
	public String toString() { return "Grow by multiplying by 10"; }

	public static void main(String[] args) {
		GenSizes sizes = GenSizes.arithmetic(1, 1000, 1);
		ExecuteAlgorithm.timeAlgorithm(
				"growth2", 
				"studio0.growinglist.OurGrowth2", 
				new IntArrayGenerator(), 
				sizes
				);	
	}
}
