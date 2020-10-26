package com.string;


public class DeleteLianXuNumberOfKZero {
	public static void main(String[] args) {
		String  tempString = "sd00000faf000dsag";
		System.out.print(deleteLianXuNumberOfKZeroMethod(tempString, 3));
	}
	
	public static String deleteLianXuNumberOfKZeroMethod(String string, int k) {
		
		if (string==null||k<1) {
			return "";
		}
		char[] array = string.toCharArray();
		int count = 0, start = -1;
		for(int i=0; i<array.length; i++) {
			//System.out.println(i+"i");
			if(array[i]!='0') {
				if(count==k) {
					while (count--!=0) {
						array[start++] = 0;
					}
				}	
				count = 0;
				start = -1;
			}else {
				count++;
				start = start== -1? i: start;
			}
		}
		StringBuffer stringb = new StringBuffer("");
		for(int i=0;i<array.length;i++) {
			if(array[i]!=0) {
				stringb = stringb.append(String.valueOf(array[i]));
			}
		}
		return stringb.toString();
	}
}
