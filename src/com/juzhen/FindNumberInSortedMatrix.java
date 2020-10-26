package com.juzhen;
//在行和列都排好顺序的矩阵中找数是否在矩阵中
public class FindNumberInSortedMatrix {
	public static void main(String[] args) {
		int[][] matrix = {{0,1,2,5}, {2,3,4,7}, {4,4,4,8}, {5, 7, 7, 9}};
		Boolean result;
		result = findNumberInMatrix(matrix, 0);
		System.out.print(result);
	}
	public static Boolean findNumberInMatrix(int[][] matrix, int number) {
		if (matrix==null) {
			return false;
		}
		Boolean result = false;
		int TR = 0, TC= matrix[0].length - 1;
		while(TR<matrix.length && TC >= 0) {
			if (matrix[TR][TC] == number) {
				result = true;
				break;
			}else if(matrix[TR][TC] >number) {
				TC = TC - 1;
			}
			else {
				TR = TR + 1;
			}
		}
		return result;
	}	
}
