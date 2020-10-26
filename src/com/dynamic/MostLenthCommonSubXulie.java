package com.dynamic;

//最长公共子序列
public class MostLenthCommonSubXulie {
	
	//1A2C3D4B56
	public static void main(String[] args) {
		String string1 = "1A2C3D4B56";
		String string2 = "B1D23CA45B6A";
		char[] arr1 = string1.toCharArray();
		char[] arr2 = string2.toCharArray();
		int[][] dp = dpmatrix(arr1, arr2);
		printMaxtrix(dp);
        System.out.println(dpmatrixString(arr1, arr2, dp));
	}
	
	
	public static int[][] dpmatrix(char[] arr1, char[] arr2){
		if (arr1==null || arr2==null||arr1.length==0||arr2.length==0) {
			return null;
		}
		int[][] matrix = new int[arr1.length][arr2.length];
		matrix[0][0] = arr1[0]==arr2[0] ? 1 : 0;
		//初始化第一行, 第一个字符的判断
		for(int j=1; j<arr2.length; j++) {
			matrix[0][j] = Math.max(matrix[0][j-1], arr1[0]==arr2[j]?1:0);
		}
		//初始化第一列, 第一个字符的判断
		for(int i=1;i<arr1.length;i++) {
			matrix[i][0] = Math.max(matrix[i][0], arr1[i]==arr2[0]?1:0);
		}
		
		for(int i=1;i<arr1.length;i++) {
			for(int j=1;j<arr2.length;j++) {
				matrix[i][j] = Math.max(matrix[i-1][j], matrix[i][j-1]);
				if(arr1[i]==arr2[j]) {
					matrix[i][j] = Math.max(matrix[i][j], matrix[i-1][j-1]+1);
				}
			}
		}
		return matrix;
	}
	
	
	public static String dpmatrixString(char[] arr1, char[] arr2, int[][] matrix){
		int m = arr1.length-1;
	    int n = arr2.length-1;
		char[] res = new char[matrix[m][n]];
		int index = res.length-1;
		while(index>=0) {
			if(n>0&&matrix[m][n]==matrix[m][n-1]) {
				n--;
			}else if(m>0&&matrix[m][n]==matrix[m-1][n]){
				m--;
			}else {
				res[index--] = arr1[m];
				m--;
				n--;
			}
		}
		return String.valueOf(res);
	}
	
	public static void printMaxtrix(int[][] matrix) {
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				System.out.print(matrix[i][j]+"   ");
			}
			System.out.println();
		}
	}
	
}
