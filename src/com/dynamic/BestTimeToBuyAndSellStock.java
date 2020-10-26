package com.dynamic;


//给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
//如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
//注意：你不能在买入股票前卖出股票。

public class BestTimeToBuyAndSellStock {
	public static void main(String[] args) {
		int[] numbers= {7,1,5,3,6,4};
		System.out.print(BestTimeToBuyAndSellStockMethod(numbers));
	}
	
	public static int BestTimeToBuyAndSellStockMethod(int[] numbers) {
		if(numbers==null||numbers.length==0){
			return 0;
		}
		//最小买入
		int minPrice = numbers[0];
		int maxShouYi = 0;
		for(int i=1;i<numbers.length;i++) {
			maxShouYi = Math.max(maxShouYi, numbers[i]-minPrice);
			minPrice = Math.min(minPrice, numbers[i]);
		}
		return maxShouYi;
	}
}
