package com.Sort;

public class QuickSort {
	public static void main(String[] args) {
		//int[] array = {2,20,2,4,5,7,2,4,10,2};
		int[] array = {4,6,2};
		quickSortMethod(array, 0, array.length-1);
		showArray(array);
	}
	
	public static void quickSortMethod(int[] array, int start, int tail) {
		if(start<tail) {
			int numberseperate =array[start];
			int midSepreate = midSeperate(array, numberseperate, start, tail);
			
			quickSortMethod(array, start, midSepreate-1);
			System.out.println(start+"gg"+midSepreate+"gg"+tail);
			quickSortMethod(array, midSepreate+1, tail);
		}
	}
	public static int midSeperate(int[] array, int number, int start, int tail) {
		int low=start,high=tail;
		while(low<high) {
			while(array[high]>=number&&low<high) high--;
			array[low]=array[high];
			while(array[low]<=number&&low<high) low++;
			array[high] = array[low];
		}
		array[low]=number;
		//此时返回start代表大于等于number的索引位置的下一个
		return low;
	}
	
	public static void showArray(int[] array) {
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]+",");
		}
		System.out.println();
	}
}
