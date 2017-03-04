package cs383;

import java.util.Stack;

//NAME: David Ruan 
//(revised to use java.util.Stack)
public class Homework4 {

	/***
	 * determines if an input array is of the format where the first n values
	 *  are false and the second n values are true for all n >= 0
	 * @param b array of booleans
	 * @return true if the Boolean array contains n false values followed by 
	 *    n true values for all n >= 0
	 */
	public static boolean StackChecker(Boolean [] b) {
		
		if (b.length%2 != 0) return false;
		if (b.length == 0) return false;
		
		Stack<Boolean> boolStack = new Stack<Boolean>();
		
		for (int i = 0; i <b.length; i++){
			boolStack.push(b[i]);
		}
		
		for (int i = 0; i <b.length/2; i++){
			if (!boolStack.pop()) return false;
		}
		
		for (int i = b.length/2; i<b.length; i++){
			if (boolStack.pop()) return false;
		}
		
		return true;
	}
	
//	public static void main(String[] args) {
//		Boolean [] c = new Boolean [] {false,true,true,true};
//		System.out.print(StackChecker(c));
//	}

}
