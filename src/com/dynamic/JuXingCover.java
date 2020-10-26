package com.dynamic;
//矩形覆盖， 2*1， 覆盖2*n矩形，有多少种方法
public class JuXingCover {
	public static void main(String[] args) {
		
	}
	public static int RectCover(int target) {
        if(target==1) {
        	return 1;
        }
        if(target==2) {
        	return 2;
        }
        int a=1, b=2, res=0;
        //考虑最后一个矩形是竖着放，还是正着放。
        for(int i=3;i<=target;i++) {
        	res = a+b;
        	a = b;
        	b= res;
        }
        return res;
	}	
}
