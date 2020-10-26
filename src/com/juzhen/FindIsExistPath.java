package com.juzhen;


public class FindIsExistPath {
	public static void main(String[] args) {
		char[] matrix = "ABCESFCSADEE".toCharArray();
		char[] str = "ABCCED".toCharArray();
		System.out.println(hasPath(matrix,3,4,str));
		int a=0;
		
	}
	
	//这里的矩阵用matrix表示
	public static boolean hasPath(char[] matrix, int rows, int cols, char[] str){
		//用于标记
		int[] flag = new int[matrix.length];
		Boolean res = false;
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				if(help(matrix, flag, rows, cols, i, j, str, 0)) {
					res = true;
				}
			}
		}
	    return res;
	}
	public static boolean help(char[] matrix, int[] flag,int rows,int cols,int i, int j, char[] str, int k) {
		int index = i*cols+j;
		if(i<0||i>=rows||j<0||j>=cols||matrix[index]!=str[k]||flag[index]==1) {
			return false;
		}
		if(k==str.length-1){
            return true;
        }
		flag[index] = 1;
		if(help(matrix, flag, rows, cols, i-1, j, str, k+1)
				||help(matrix, flag, rows, cols, i+1, j, str, k+1)
				||help(matrix, flag, rows, cols, i, j-1, str, k+1)
				||help(matrix, flag, rows, cols, i, j+1, str, k+1)){
			return true;
		}
		flag[index] = 0; 
		return false;
	}
	

}
