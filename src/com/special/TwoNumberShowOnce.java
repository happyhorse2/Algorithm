package com.special;

import com.sun.xml.internal.ws.api.ha.HaInfo;

//一个数组中其他数字都出现两次，只有两个元素出现了出现了一次
public class TwoNumberShowOnce {
	public static void main(String[] args) {
		int[] number = {1,2,3,4,4,5,2,1};
		showTwo(number);
	}
	
	public static void showTwo(int[] number) {
		if(number==null) {
			return;
		}
		int res = 0;
		for(int i=0;i<number.length;i++) {
			res = res^number[i];
		}
		//能找到两个数的最右位不相同的为1，的两个数在这个位上一个为0一个为1。
		int rightOne = res & (~res+1);
		int numberOne = 0;
		for(int i=0; i<number.length;i++) {
			if((number[i]&rightOne)!=0) {
				numberOne = numberOne^number[i];
			}
		}
		int numberTwo = res^numberOne;
		System.out.print(numberOne+", "+ numberTwo);
		
	}
}
