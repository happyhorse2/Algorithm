package com.shuzu;

//给定n个非负整数，表示水库当中隔板的高度。
//每两块隔板之间的距离为1，当下要从n个隔板当中选出两个，
//在其中注水，并且要使得容纳的水尽量多。请问最多能容纳多少水？
//可以忽略隔板的宽度，将水库看成是正规的长方体。
public class WeiWaterProblem {
	public static void main(String[] args) {
		int[] array= {1,8,6,2,5,4,8,3,7};
		System.out.print(MaxWeiWaterProblem(array));
	}
	
	public static int MaxWeiWaterProblem(int[] array) {
		int res = Integer.MIN_VALUE;
		int start=0, last = array.length-1;
		while(start<last) {
			res = Math.max(res, (last-start)*Math.min(array[start], array[last]));
			//等于随便选取一个
			if(array[start]<=array[last]) {
				start++;
			}else {
				last--;
			}
		}
		return res;
	}
}
