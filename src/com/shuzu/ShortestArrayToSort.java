package com.shuzu;


//在无序数组中，求出需要排序的最短子数组长度
public class ShortestArrayToSort {
	public static void main(String[] args) {
		int[] arrays = new int[] {1, 5, 3, 4, 2, 2, 2};
		int result = 0;
		result = getminsortlength(arrays);
		System.out.print(result);
	}
	public static int getminsortlength(int[] arr) {
		if (arr.length<2 || arr==null) {
			return 0;
		}
		int nominindex = -1;
		int nomaxindex = -1;
		int min = arr[arr.length-1];
		int max = arr[0];
		for(int i=arr.length-1; i>=0; i--) {
			if (arr[i]> min) {
				nominindex = i;
			}else {
				min = arr[i];
			}
		}
		if (nominindex ==-1) {
			return 0;
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]<max) {
				nomaxindex = i;
			}else {
				max =  arr[i];
			}
		}
		return nomaxindex-nominindex+1;
	}
}
