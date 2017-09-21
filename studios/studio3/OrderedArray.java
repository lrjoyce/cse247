package studio3;

public class OrderedArray<T extends Comparable<T>> implements PriorityQueue<T> {

	public T[] array;
	private int size;
	
	@SuppressWarnings("unchecked")
	public OrderedArray(int maxSize) {
		array = (T[]) new Comparable[maxSize];
		size = 0;
	}
	
	@Override
	public boolean isEmpty() {
		
		if(array.length <=0) {
			return true;
		}
		return false;
	}

	@Override
	public void insert(T thing) {
		//array = new T[array.length +1];
		for(int i=0; i<=array.length; i++){
			if(thing <= array[i] && thing=> array[i+1]) {
				
			}
		}
	}
	
	@Override
	public T extractMin() {
		
		T min = array[0];
		//remove first element
		return min;
	}

}
