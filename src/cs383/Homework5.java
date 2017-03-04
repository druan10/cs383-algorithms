//David Ruan

package cs383;

public class Homework5 {

	
	/***
	 * determines if a value is present in the matrix or not
	 * 
	 * 
	 * @param matrix NxN matrix where row values are increasing left to right and
	 *      column values are increasing from top to bottom
	 * @param search value
	 * @return returns true if the value is contained in the matrix, otherwise false
	 */
	public static boolean OrderedMatrixContains(int [][] matrix, int value) {
		int currentRow = 0;
		int currentCol = matrix.length-1;
		
		while(currentRow<matrix.length && currentCol>=0){
			
			System.out.println("\n["+currentRow+"]["+currentCol+"] = "+matrix[currentRow][currentCol]+"\n---------------"); //Testing
			
			
			if (matrix[currentRow][currentCol]==value) return true;
			
			/**
			 * When starting this homework, I started searching from [0][0] but I couldn't figure out how to update currenti & currentj
			 * for each check. Starting from [0][0], I can't decrease currenti or currentj without a more complex if else statement.
			 * I used this site http://www.geeksforgeeks.org/search-in-row-wise-and-column-wise-sorted-matrix/
			 * which suggested starting from the top right.
			 * My code isn't O(N) as the position im checking is only changed by 1, either vertically or horizontally. 
			 * Diagonals are required to keep the search under N amount of iterations. (You can reach any position in the matrix starting from
			 * a corner, if you can move diagonally.
			 * Not sure how I SHOULD set up the conditionals required to change currentCol and currentRow in the same for loop iteration
			 */
			
			if (matrix[currentRow][currentCol]>value){
				currentCol--;
			}else{
				currentRow++;
			}
			
		}
		
		return false;
	}
	
//	public static void main(String[] args) {
//		int[][] matrix = new int[][]{
//			{0,1,5,8},
//			{2,6,8,9},
//			{5,8,9,10},
//			{7,11,13,15}
//			};
//		System.out.println(OrderedMatrixContains(matrix, 13));
//	}
}
