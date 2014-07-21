package org.crackcode.ch1;

public class Matrix {
	 public static void printMatrix(int[][] matrix){
		 for (int i = 0; i < matrix.length; i++){
			 for (int j = 0; j < matrix[0].length; j++)
				 System.out.printf("%d  ", matrix[i][j]);
				System.out.println();
		 }
	 }
	 
	 public static void printMatrix(double[][] matrix){
		 for (int i = 0; i < matrix.length; i++){
			 for (int j = 0; j < matrix[0].length; j++)
				 System.out.printf("%f  ", matrix[i][j]);
				System.out.println();
		 }
	 }
}
