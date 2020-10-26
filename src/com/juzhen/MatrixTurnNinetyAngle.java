package com.juzhen;
//正方形矩阵
public class MatrixTurnNinetyAngle {
	public static void main(String[] args) {
		System.out.print("hello world");
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		printMatrix(matrix);
		turnLevelmatrix(matrix);
		System.out.println();
		printMatrix(matrix);
	}
	public static void turnLevelmatrix(int[][] matrix) {
		int TR=0, TC=0;
		int DR=matrix.length-1, DC=matrix[0].length-1;
		while(TR<=DR && TC<=DC ) {
			turnOnelevelGroup(matrix, TR++, TC++, DR--, DC--);
		}
	}
	public static void turnOnelevelGroup(int[][] matrix, int TR,int TC,int DR, int DC) {
		int times = DR-TR;
		int temp = 0;
		for(int i=0; i<times; i++) {
			temp = matrix[TR][TC+i];
			matrix[TR][TC+i] = matrix[DR-i][TC];
			matrix[DR-i][TC] = matrix[DR][DC-i];
			matrix[DR][DC-i] = matrix[TR+i][DC];
			matrix[TR+i][DC] = temp; 
		}
	}
	public static void printMatrix(int[][] matrix) {
		for (int i=0; i<matrix.length;i++) {
			for(int j=0; j<matrix[0].length;j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
}
