package com.dynamic;

public class MostLengthCommonSubString {
	public static void main(String[] args) {
		String string1 = "12345ABCD";
		String string2 = "12345EF";
		System.out.print(MostLengthCommonSubStringMethod(string1, string2));
	}
	
	public static String MostLengthCommonSubStringMethod(String string1, String string2){
		char[] arr1 = string1.toCharArray();
		char[] arr2 = string2.toCharArray();
		int[][] matrix = dpmatirx(arr1, arr2);
		int max = 0;
		int end = 0;
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				if(matrix[i][j]>max) {
					end = i;
					max = matrix[i][j];
				}
			}
		}
		return string1.substring(end-max+1, end+1);
	}
	// 分别以i和j结尾的公共字符串长度，
	public static int[][] dpmatirx(char[] arr1, char[] arr2) {
		int[][] matrix =  new int[arr1.length][arr2.length];
		//初始化第一行, 第一个字符的判断
		for(int j=0; j<arr2.length; j++) {
			if(arr1[0]== arr2[j]) {
				matrix[0][j]=1;
			}
		}
		//初始化第一列, 第一个字符的判断
		for(int i=0;i<arr1.length;i++) {
			if(arr1[i] == arr2[0]) {
				matrix[i][0] = 1;
			}
		}
		
		for(int i=1;i<arr1.length;i++) {
			for(int j=1;j<arr2.length;j++) {
				if (arr1[i]!=arr2[j]) {
					matrix[i][j]=0;
				}else {
					matrix[i][j]=matrix[i-1][j-1]+1;
				}
			}
		}
		return matrix;
	}
}
