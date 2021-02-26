package com.dynamic;

//最长递增子序列不连续
public class MostLengthDiZengSubXulie {
	
	public static void main(String[] args) {
		int[] arr = {2,5,1,4,3,6,7};
		int[] result = dp(arr);
		result =  generateLIS(arr, result);
		for(int i=0;i<result.length;i++) {
			System.out.print(result[i]);
		}
	}
	public static int[] dp(int[] arr) {
		if (arr.length==0||arr==null) {
			return null;
		}
		int[] dpLength = new int[arr.length];
		for(int i=0;i<arr.length;i++) {
			dpLength[i]=1;
			for(int j=0;j<i;j++) {
				if (arr[i]>arr[j]) {
					dpLength[i] = Math.max(dpLength[i], dpLength[j]+1);
				}
			}
		}
		return dpLength;
	}
	
	public static int[] generateLIS(int[] arr, int[] dplength) {
		int len = 0;
		int index = 0;
		//找出递增子序列长度和结尾索引
		for(int i=0;i<dplength.length;i++) {
			if (dplength[i]>len) {
				len = dplength[i];
				index = i;
			}
		}
		int[] lis = new int[len];
		//逆序最后一个赋值
		lis[--len] = arr[index];

		//arr[i]为下一个最长子序列的数，从后向前
		for(int i=index;i>=0;i--) {
			if(arr[i]<arr[index]&&dplength[i]==dplength[index]-1) {
				lis[--len]= arr[i];
				index = i;
			}
		}
		return lis;
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
