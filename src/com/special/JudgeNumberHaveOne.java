package com.special;
//判断一个整数二进制有几个1, 负数用补码表示
public class JudgeNumberHaveOne {
	public static void main(String[] args) {
		int res = JudgeNumberHaveOneMethod(-2);
		System.out.print(res);
	}
	
	public static int JudgeNumberHaveOneMethod(int number) {
		if (number==0) {
			return 0;
		}
		int res=0;
		while(number!=0) {
			number = number&(number-1);
			res++;
		}
		return res;
	}
}
