package com.special;
//快速幂算法, a和b都是整数，求a的b次幂。
public class ADeBCiMi {
	public static void main(String[] args) {
		System.out.println(method(2, 2));
	}
	
	public static float method(int a, int b) {
		float res = 0.0f;
		if(b==0) {
			return 1;
		}
		if(b<0) {
			res = 1/method(a, -b);
			return res;
		}
		if(b%2==0) {
			res = method(a*a, b/2);
			return res;
		}else {
			res = method(a*a, b/2)*a;
			return res;
		}
	}
}
