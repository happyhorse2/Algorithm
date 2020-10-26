package com.dynamic;


public class MostLengthHuiWenSubString {
	public static void main(String[] args) {
		String string1 = "abacccccd";
		char[] array = string1.toCharArray();
		String string2 = longestSubStringHuiWen(array, string1);
		System.out.println(string2);
	}
	
	public static String longestSubStringHuiWen(char[] stringarray, String s) {
		if (stringarray==null || stringarray.length == 0) {
			return "";
		}
		boolean[][] dp = new boolean[stringarray.length][stringarray.length];
		int len = stringarray.length;
		String string = null;
		int maxlen = Integer.MIN_VALUE;
		//i往小了走，j往大了走。
		for(int i=len-1; i>=0; i--){
			for(int j=i;j<len;j++){
				//长度为2时，还像等肯定是回文串
				dp[i][j] = (stringarray[i] == stringarray[j]) && ((j-i < 3 || dp[i+1][j-1] == true));
				if (dp[i][j]==true && j-i+1>maxlen) {
					string = s.substring(i, j+1);
					maxlen = string.length();
				}
			}
		}
		return string;
	}
	
	public static String mostLengthHuiwenZichuan() {
		String string1 = "aaasdfdafdsfasf";
		String resultString = "";
		boolean[][] flag = new boolean[string1.length()-1][string1.length()-1];
		int max = 0;
		int i = string1.length()-1;
		int j=i;
		for(i=string1.length()-1; i>=0;i--) {
			for(j=i;j<string1.length();j++) {
				flag[i][j] = (string1.charAt(i)==string1.charAt(j))&&(i-j<3||flag[i+1][j-1]);
				if(flag[i][j]==true&&j-i+1>max) {
					resultString = string1.substring(i,j+1);
				}
			}
			
		}
		return resultString;
	}
}
