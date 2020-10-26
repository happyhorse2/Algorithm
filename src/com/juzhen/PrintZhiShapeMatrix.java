package com.juzhen;

public class PrintZhiShapeMatrix {
	public static void main(String[] args) {
		System.out.print("hello world");
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		printZhimatrix(matrix);
	}
	public static void printZhimatrix(int[][] matrix) {
		int TR=0, TC=0, DR=0, DC=0;
		Boolean downtoup = true;
		int endR = matrix.length-1;
		int endC = matrix[0].length-1;
		while(TR !=endR+1) {
			printDiagonalData(matrix,TR,TC,DR,DC,downtoup);
			TR = TC == endC ? TR+1: TR;
			TC = TC == endC ? TC: TC+1;
			DC = DR == endR ? DC+1: DC;
			DR = DR == endR ? DR: DR+1;
			downtoup = !downtoup;
		}
	}
	public static void printDiagonalData(int[][] matrix, int TR,int TC,int DR, int DC, Boolean downtoup) {
		if (downtoup) {
			while(DR!=TR-1) {
				System.out.print(matrix[DR--][DC++]);
			}
		}else {
			while(TR!=DR+1) {
				System.out.print(matrix[TR++][TC--]);
			}
		}
		System.out.println();
	}
}
