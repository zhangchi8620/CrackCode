package org.crackcode.ch1;

public class RotateImage {
	
	// Method 1: use additional memory
	public static int[][] rotateImage1(int[][] matrix, int n) {
		 int[][] image = { {1, 2, 3},
				 			{4, 5, 6},
				 			{7, 8, 9}};
		 
		 for (int i = 0; i < n; i++){
			 for (int j = 0; j < n; j++){
				 if (i <= j)
					 break;
				 int tmp = image[i][j];
				 image[i][j] = image[j][i];
				 image[j][i] = tmp;
			 	}
		 }
		 
		 for (int i = 0; i < n / 2; i++){
			 for (int j = 0; j < n; j++){
				 int tmp = image[i][j];
				 image[i][j] = image[n-1-i][j];
				 image[n-1-i][j] = tmp; 

			 }
		 }
		 
		 return image;
	 }

	// Method 2: rotate in place
	 public static int[][] rotateImage2(int[][] matrix, int n) {		 
		 for (int layer = 0; layer < n / 2; ++layer) {
		 int first = layer; int last=n-1-layer;
			 for(int i = first; i < last; ++i) {
				 int offset = i - first;
				 // save top
				 int top = matrix[first][i]; 
				 // left -> top
				 matrix[first][i] = matrix[last-offset][first];
				 // bottom -> left
				 matrix[last-offset][first] = matrix[last][last - offset];
				 // right -> bottom
				 matrix[last][last - offset] = matrix[i][last];
				 // top -> right
				 matrix[i][last] = top; // right <- saved top }
			 } 
		  }
		 return matrix;
	}
	 

	 
	 public static void main(String[] args) {
		 int[][] matrix = { {1, 2, 3},
		 			{4, 5, 6},
		 			{7, 8, 9}};
		 int n = 3;
		 
		 System.out.println("Input image:");
		 Matrix.printMatrix(matrix);
		 matrix = rotateImage1(matrix, n);
		 System.out.println("Rotated image:");

		 Matrix.printMatrix(matrix);

	 }
}