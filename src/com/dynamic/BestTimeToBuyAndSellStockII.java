package com.dynamic;

//给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
//如果交易次数无限制，设计一个算法来计算你所能获取的最大利润。
//注意：你不能在买入股票前卖出股票。
//使用状态机原理
public class BestTimeToBuyAndSellStockII {
	public static void main(String[] args) {
		int[] numbers= {7,1,5,3,6,4};
		System.out.print(BestTimeToBuyAndSellStockIIMethod(numbers));
	}
	
	public static int BestTimeToBuyAndSellStockIIMethod(int[] numbers) {
		if(numbers==null||numbers.length==0) {
			return 0;
		}
		int hold = -numbers[0];  //今天手里还持有股票，收益
		int sold = 0;  //今天手里没有股票，持有的收益
		for(int i=1;i<numbers.length;i++) {
			int pre_hold = hold;
			int pre_sold = sold;
			hold = Math.max(pre_hold, pre_sold-numbers[i]);
			sold = Math.max(pre_sold, pre_hold+numbers[i]);
		}
		return sold;
	}
}
