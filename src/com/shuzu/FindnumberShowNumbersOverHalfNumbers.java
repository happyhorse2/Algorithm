package com.shuzu;

import java.util.HashMap;

public class FindnumberShowNumbersOverHalfNumbers {
	public static void main(String[] args) {
		int[] array = {1,2,4,5,2,2,2,5};
		System.out.print(method(array));
	}
	
	public static int method(int[] array) {
		HashMap<String, Integer> map =  new HashMap<String, Integer>();
		int resnumber=Integer.MIN_VALUE;
		for(int i = 0; i<array.length; i++) {
			int temptimes = 0;
			String keyString = array[i]+"";
			if(map.containsKey(keyString)) {
				temptimes = map.get(keyString)+1;
				map.put(keyString, temptimes);
			}else {
				temptimes = temptimes+1;
				map.put(keyString, temptimes);
			}
			if(temptimes>=array.length/2) {
				resnumber = array[i];
				break;
			}
		}
		return resnumber;
	}
}
