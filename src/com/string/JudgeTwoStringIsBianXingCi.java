package com.string;

public class JudgeTwoStringIsBianXingCi {
	public static void main(String[] args) {
		Boolean boolean1 = judgeTwoStringIsBianXingCiMethod("s5afd", "sdadf");
		System.out.print(boolean1);
	}
	
	//假设字符串中单个字符对应的码值是255
	public static boolean judgeTwoStringIsBianXingCiMethod(String string1, String string2) {
		Boolean boolean1 = true;
		if(string1.length()!=string2.length()) {
			return false;
		}
		int[] map = new int[256];
		for(int i=0; i<string1.length(); i++) {
			map[string1.charAt(i)]++;
			map[string2.charAt(i)]--;
		}
		for(int i=0; i<map.length;i++) {
			if(map[i]!=0) {
				boolean1 = false;
			}
		}
		return boolean1;
	}
	
	
}
