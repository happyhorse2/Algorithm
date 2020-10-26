package com.string;


//将字符串中数字相加，忽略小数点的左右，不忽略负号的作用
public class SumAllNumberInString {
	public static void main(String[] args) {
		int number =  sumAllNumberInStringMethod("13.89,ddd,-90");
		System.out.println(number);
	}
	
	public static int sumAllNumberInStringMethod(String string) {
		int num = 0;
		int res = 0;
		Boolean zheng = true;
		int ch = 0;
		char[] chararray = string.toCharArray();
		for(int i=0; i<chararray.length; i++) {
			ch =  chararray[i]-'0';
			if(ch<0 || ch>9) {
				res = res+num;
				num = 0;//每次需要重置0
				if(chararray[i]=='-') {
					if(i-1>-1||chararray[i-1]=='-') {
						zheng=!zheng;
					}else {
						zheng = false;
					}
				}else {
					zheng = true;
				}
			}else {
				num = num*10 + (zheng?ch:-ch);
			}
		}
		res=res+num;
		return res;
	}
}
