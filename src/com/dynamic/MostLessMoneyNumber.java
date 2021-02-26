package com.dynamic;

//使用钱币个数最少
public class MostLessMoneyNumber {
	public static void main(String[] args) {
		int money=7;
		int[] chargemoney = {2,5};
		//
		System.out.print(mostlessMoneyNumerMethodOfPress(money, chargemoney));
	}
	
	public static int mostlessMoneyNumerMethod(int money, int[] chargeMoney) {
		if(money<0||chargeMoney==null||chargeMoney.length==0) {
			return 0;
		}
		//result[0...i][0] 为0
		int[][] result = new int[chargeMoney.length][money+1];
		//初始化Integer.MAX_VALUE找不开
		for(int j=1;j<=money;j++) {
			result[0][j] = Integer.MAX_VALUE;
			if (j-chargeMoney[0]>=0 && result[0][j-chargeMoney[0]]!=Integer.MAX_VALUE){
				result[0][j] =  result[0][j-chargeMoney[0]]+1;
			}
		}
		printMaxtrix(result);
		//分为使用和不是用i货币两部分，去对比。
		int left = 0;
		for(int i=1;i<chargeMoney.length;i++) {
			for(int j=1;j<=money;j++) {
				left = Integer.MAX_VALUE;
				//使用当前货币需要个数
				if (j-chargeMoney[i]>=0 && result[i][j-chargeMoney[i]]!=Integer.MAX_VALUE){
					left =  result[i][j-chargeMoney[i]]+1;
				}
				//与上一个不使用i货币相比取小的。
				result[i][j] = Math.min(left, result[i-1][j]);
			}
		}
		return result[chargeMoney.length-1][money];
	}
	
	public static int mostlessMoneyNumerMethodOfPress(int money, int[] chargeMoney) {
		if(money<0||chargeMoney==null||chargeMoney.length==0) {
			return 0;
		}
		//result[0...i][0] 为0
		int[] result = new int[money+1];
		for(int j=1;j<=money;j++) {
			result[j] = Integer.MAX_VALUE;
			if (j-chargeMoney[0]>=0 && result[j-chargeMoney[0]]!=Integer.MAX_VALUE){
				result[j] =  result[j-chargeMoney[0]]+1;
			}
		}

		int left = 0;
		for(int i=1;i<chargeMoney.length;i++) {
			for(int j=0;j<=money;j++) {
				left = Integer.MAX_VALUE;
				//使用当前货币需要个数
				if (j-chargeMoney[i]>=0 && result[j-chargeMoney[i]]!=Integer.MAX_VALUE){
					left =  result[j-chargeMoney[i]]+1;
				}
				//与上一个相比取小的
				result[j] = Math.min(left, result[j]);
			}
		}
		return result[money];
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
