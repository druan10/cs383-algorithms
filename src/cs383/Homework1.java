package cs383;

public class Homework1 {

	/***
	 * evaluates if two strings are circular permutations of each other
	 * 
	 *  examples: 
	 *  	s1="abcd", s2="cdab" returns true.
	 *  	s1="abcd", s2="cdba" returns false.
	 *  	s1="abcd", s2="bcd" returns false
	 *  
	 * @param s1 first string to evaluate
	 * @param s2 second string to evaluate
	 * @return true if s1 and s2 are circular permutations of each other, otherwise false
	 * @throws NullPointerException if s1 or s2 is null
	 */
	
	public static boolean isCircularPermutation(String s1, String s2) {
		
		//Error checking
		if (s1==null || s2==null){
			throw new NullPointerException();
		}
		
		if (s1.length()!=s2.length()){
			 return false;
		}
		
		//Convert to character array for comparison
		char[] string1 = s1.toCharArray();
		char[] string2 = s2.toCharArray();
		char temp;
		//Instantiate variable outside of loop 
		boolean equal =  true;
		
		//Rearrange strings and compare, if same, return true
		for (int i=0;i<string2.length;i++){
			
			equal=true;
			temp=string2[0];
			
			for (int j=0;j<string2.length-1;j++){
				string2[j]=string2[j+1];	
			}
			
			string2[string2.length-1]=temp;
			
			for (int k=0;k<string2.length;k++){
				if (string1[k]!=string2[k]){
					equal = false;
				}
			}
			
			if (equal){
				return true;
			}
			
		}
		
		return false;
		
	}
	
}
