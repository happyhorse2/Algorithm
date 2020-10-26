package com.juzhen;

public class PrintCircleMatrix {
	public static void main(String[] args) {
		System.out.print("hello world");
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		levelOrderPrint(matrix);
	}
	public static void levelOrderPrint(int[][] matrix) {
		int TR=0, TC=0;
		int DR=matrix.length-1, DC=matrix[0].length-1;
		while(TR<=DR && TC<=DC ) {
			printEdge(matrix, TR++, TC++, DR--, DC--);
		}
	}
	public static void printEdge(int[][] matrix, int TR,int TC,int DR, int DC) {
		int CR=TR, CC=TC;
		if ((DR-CR) == 0) {
		   for (int i=CC; i<=DC; i++) {
			   System.out.print(matrix[CR][i]);
		   }
		}
		else if ((DC-CC) ==0) {
			for(int i=CR;i<=DR;i++) {
				System.out.print(matrix[i][CC]);
			}
		}
		else {
			while (CC!=DC) {
				System.out.print(matrix[CR][CC]);
				CC++;
			}
			while(CR!=DR) {
				System.out.print(matrix[CR][CC]);
				CR++;
			}
			while(CC!=TC) {
				System.out.print(matrix[CR][CC]);
				CC--;
			}
			while(CR!=TR) {
				System.out.print(matrix[CR][CC]);
				CR--;
			}
		}
	}
}
