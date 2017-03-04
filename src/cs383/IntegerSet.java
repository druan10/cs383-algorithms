package cs383;

// you may not use any other import statements for this .class!
import java.util.Arrays;
import java.lang.IllegalArgumentException;

public class IntegerSet {
	
	private final int[] a;
	
	/***
	 * 
	 * @param input array of integers
	 * @throws IllegalArgumentException if keys is null
	 */
	public IntegerSet(int[] keys)
	{
		if (keys==null) throw new IllegalArgumentException();
		int duplicates = 0;
		Arrays.sort(keys);
		
		for (int i = 0;i<keys.length-1;i++){
			if (keys[i]==keys[i+1]){
				duplicates++;
			}
		}
		
		// create and sort defensive copy
		a = new int[keys.length-duplicates];
		int index=0;
		
		for (int i =0;i<keys.length;i++){
			if (!contains(keys[i])){
	    		a[index] = keys[i];
	    		index++;
	    	}
		}
	}
			
	/***
	 * 
	 * @return the number of elements in the IntegerSet
	 */
	public int size() { 
		return a.length; 
	}
	  
	/***
	 * determines if an integer is a member of the IntegerSet or not.
	 * 
	 * @param key the integer to check
	 * @return true if the integer is a member of the IntegerSet, otherwise false
	 */
	public boolean contains(int key) {  
		return _binary_search(key) != -1;  
	}
						
	/***
	* peforms a binary search on a sorted array of integers
	*  
	* @param key integer to search for
	* @return position in the array where an instance of the integer occurs, -1 if the key is not present
	*/
	private int _binary_search(int key) {
	  					
	     int lo  = 0;
	     int hi = a.length - 1;
	     while (lo <= hi)
	      { // Key is in a[lo..hi] or not present.				
	         int mid = lo + (hi - lo) / 2;
	         if      (key < a[mid]) hi = mid - 1;
	         else if (key > a[mid]) lo = mid + 1;
	         else return mid;				
	
	      }					
	
	     return -1; 
	  }		
	
	/***
	 * 
	 * @param IntegerSet B to compare to
	 * @return this == IntegerSet B
	 */
	public boolean equals(Object B){ // Should be object to override equals method
		
		if (this == B) return true;
		if (B == null) return false;
		if (B.getClass()==this.getClass()){
			
			IntegerSet that = (IntegerSet)B;
			if (this.size()!=that.size()) return false;
			
			for (int i=0;i<size();i++){
				if (this.a[i]!=that.a[i]) return false;
			}
		}
		
		return true;
	}
}
