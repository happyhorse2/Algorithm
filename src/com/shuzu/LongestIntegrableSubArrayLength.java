package com.shuzu;

import java.util.HashSet;


//最长可整合子数组长度
//例如【5，5，3，2，6，4，8】，可整合数组为排序后每个元素之间相差1，就为可整合数组，5，3，2，6，4为可整合数组
public class LongestIntegrableSubArrayLength {
	public static void main(String[] args) {
		int[] array = new int[]{5,5};
		int result = getLongestIntegrableSubArrayLength(array);
		System.out.println(result);
	}
	public static int getLongestIntegrableSubArrayLength(int[] arr) {
		if ( arr==null || arr.length==0) {
			return 0;
		}
		int longest = 0;
		int max = 0;
		int min = 0;
		HashSet<Integer> arrayvalueHashSet = new HashSet<Integer>();
		for (int i = 0; i < arr.length; i++) {
			max =  Integer.MIN_VALUE;
			min =  Integer.MAX_VALUE;
 			for(int j=i; j<arr.length; j++) {
				if(arrayvalueHashSet.contains(arr[j])){
					break;
				}
				else {
					arrayvalueHashSet.add(arr[j]);
					max =  Math.max(arr[j], max);
					min =  Math.min(arr[j], min);
					if (max-min== j-i) { //数的间隔等于索引的间隔
						longest = Math.max(longest, max-min+1);
						System.out.println(longest);
					}
				}
			}
			arrayvalueHashSet.clear();
		}
		return longest;
	}
}
