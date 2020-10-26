package com.string;

public class JudgeTwoStringIsXuanZhuanCi {
	public static void main(String[] args) {
		Boolean result;
		result = iudgeTwoStringIsXuanZhuanCiMethod("2230", "3022");
		System.out.print(result);
	}
	
	public static boolean iudgeTwoStringIsXuanZhuanCiMethod(String string1, String  string2) {
		if (string1==null||string2==null||string1.length()==0||string2.length()==0) {
			return false;
		}
		String temp = string1+string1;
		return temp.indexOf(string2)!=-1;
	}
}
