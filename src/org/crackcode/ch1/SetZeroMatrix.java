package org.crackcode.ch1;
import java.util.ArrayList;

public class SetZeroMatrix {
	public static double[][] setZeroMatrix(double[][] matrix){
		int row = matrix.length;
		int col = matrix[0].length;
		ArrayList<Integer> idxRow = new ArrayList<Integer>();
		ArrayList<Integer> idxCol = new ArrayList<Integer>();
		for(int i = 0; i < row; i++)
			for(int j = 0; j < col; j++)
				if(matrix[i][j] == 0 && (!idxRow.contains(i)) && (!idxCol.contains(j))){
					//System.out.println("i: " + i + "j: " + j);
					idxRow.add(i);
					idxCol.add(j);
				}
		
			System.out.println(idxRow);
			System.out.println(idxCol);
		
		if (!idxRow.isEmpty()){
			for(int i = 0; i < row; i++){
				for(int j = 0; j < col; j++){
	
					if (idxRow.contains(i) || idxCol.contains(j)){
						matrix[i][j] = 0;
					}
				}
			}
		}
		return matrix;
	}
	public static double[][] setZeroMatrix2(double[][] matrix){
		int[] row = new int[matrix.length];
		int[] col = new int[matrix[0].length];
		for(int i = 0; i < matrix.length; i++)
			for(int j = 0; j < matrix[0].length; j++)
				if(matrix[i][j] == 0 ){
					row[i] = 1;
					col[j] = 1;
				}

			for(int i = 0; i < matrix.length; i++){
				for(int j = 0; j < matrix[0].length; j++){
					if (row[i] == 1 || col[j] == 1){
						matrix[i][j] = 0;
					}
				}
			}
		
		return matrix;
	}
	public static void main(String[] args) {
		double[][] matrix = { {1.1, 0, 3, 4},
	 			{-4, 0, 0,19},
	 			{7.1, 8.4, 9, 100}};
		Matrix.printMatrix(matrix);

		//Matrix.printMatrix(setZeroMatrix(matrix));
		Matrix.printMatrix(setZeroMatrix2(matrix));
	}
}
