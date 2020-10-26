package com.string;


public class TiHuanSpace {
	public static void main(String[] args) {
		StringBuffer aBuffer = new StringBuffer("we are Happy");
		String resultString = replaceSpace(aBuffer);
		System.out.print(resultString);
	}
	public static String replaceSpace(StringBuffer str) {
		if (str==null) {
			return "";
		}
    	int space_number = 0;
    	for(int i=0;i<str.length();i++) {
    		if(str.charAt(i)==' ') {
    			space_number++;
    		}
    	}
    	char[] array = new char[space_number*2+str.length()];
    	int j = array.length-1;
    	for(int i=str.length()-1;i>=0;i--) {
    		if(str.charAt(i)==' ') {
    			space_number++;
    			array[j--]='0';
    			array[j--]='2';
    			array[j--]='%';
    		}else {
    			array[j--] = str.charAt(i);
    		}
    	}
    	return String.valueOf(array);
	}
}
