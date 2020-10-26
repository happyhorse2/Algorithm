package com.dynamic;
//青蛙一次可以跳一个台阶，或两个台阶，求青蛙跳到n阶台阶共有多少种跳法


public class TiaoTaiJie {
    
	public static void main(String[] args) {
		
	}
	public static int jump(int n) {
		if(n==1) {
			return 1;
		}
		if(n==2) {
			return 2;
		}
		int a=1, b=2, res=0;
		for(int i=3;i<=n;i++) {
			res = a+b;
			a = b;
			b= res;
		}
		return res;
	}
}

