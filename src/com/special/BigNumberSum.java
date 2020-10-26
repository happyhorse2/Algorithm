package com.special;



public class BigNumberSum {
	public static void main(String[] args) {
		String number1 = "12343545441";
		String number2 = "234134135151";
		String result = bigNumberSum(number1, number2);
		System.out.println(result);
		long a = 12343545441L;
		long b = 234134135151L;
		System.out.print(a+b);
	
	}
	
	public static String bigNumberSum(String number1, String number2) {
		String num1 = new StringBuffer(number1).reverse().toString();
		String num2 = new StringBuffer(number2).reverse().toString();
		int num1Length = num1.length();
		int num2Length = num2.length();
		int maxLength = num1Length>num2Length?num1Length:num2Length;
		StringBuffer res = new StringBuffer();
		int jinwei = 0;
		for (int i = 0; i < maxLength; i++) {
			int intnumber1 = i<num1Length?Integer.parseInt(num1.charAt(i)+""):0;
			int intnumber2 = i<num2Length?Integer.parseInt(num2.charAt(i)+""):0;
			res.append(String.valueOf((intnumber1+intnumber2+jinwei)%10));
			jinwei = (intnumber1+intnumber2+jinwei)/10;
		}
		if(jinwei!=0) {
			res.append(jinwei);
		}
		String result = res.reverse().toString();
		return result;
	}
}
