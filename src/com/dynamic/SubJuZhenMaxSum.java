package com.dynamic;


public class SubJuZhenMaxSum {
	public static void main(String[] args) {
		int[][] array = {{-90,48,78}, {64, -40, 64}, {-81, -7, 66}};
//		126
//		150
//		223
//		223
//		223
//		223
//		223
		System.out.print(subMaxMatrix(array));
	}
	
	public static int subJuZhenMaxSum(int[][] array) {
		int maxsum = Integer.MIN_VALUE;
		for(int i = 0;i<array.length;i++) {
			int[] num = new int[array[0].length];
			for(int j=i; j<array.length;j++) {
				for(int k=0;k<array[0].length;k++) {
					num[k]= num[k]+array[j][k];
				}
				maxsum = Math.max(maxsum, subArrayMaxSum(num));
				System.out.println(maxsum);
//				126
//				150
//				223
//				223
//				223
//				223
//				223
			}
		}
		return maxsum;
	}
	
	public static int subMaxMatrix(int[][] array) {
		int[][] rowSum = new int[array.length][array[0].length];
		int[] sum = new int[array[0].length]; 
		for(int i=0;i<array.length;i++) {
			for(int j=0;j<array[0].length;j++) {
				sum[j]=array[i][j]+sum[j];
				rowSum[i][j] = rowSum[i][j]+sum[j];
			}
		}
		int sumNumber =0;
		for(int i=0;i<rowSum.length;i++) {
			sumNumber = Math.max(sumNumber, subArrayMaxSum(rowSum[i]));
		}
		return sumNumber;
		
	}
	
	
	public static int subArrayMaxSum(int[] array) {
		int maxsum=Integer.MIN_VALUE, sum=0;
		for(int i=0;i<array.length;i++) {
			if(sum<0) {
				sum = array[i];
			}else {
				sum = sum+array[i];
			}
			maxsum =  Math.max(maxsum, sum);
		}
		return maxsum;
	}
}
