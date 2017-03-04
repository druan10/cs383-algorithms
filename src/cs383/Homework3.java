package cs383;

public class Homework3 {
	
	/***
	 * 
	 * @param int[] a
	 * @return sorted int[] in increasing order
	 */
	public static int[] sort(int [] a) {
		int n = a.length;
		int did_swap = 1;
		int t;
		
		//Sort adjacent integers
		while (did_swap == 1){
			did_swap = 0;
			for (int i = 1; i<n-1;i++){
				if (a[i-1]>a[i]){
					t = a[i];
					a[i]=a[i-1];
					a[i-1] = t;
					did_swap = 1;
				}
			}
		}
		
		return a;
	}
	
	//Test Main Method
	public static void main(String[] args) {
		int[] test = new int[] {3,4,8,2,1,7};
		test = sort(test);
		for (int i = 0;i<test.length; i++){
			System.out.print(test[i]);
		}
	}
}
