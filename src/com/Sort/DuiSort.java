package com.Sort;


//堆排序，小根堆
public class DuiSort {
	public static void main(String[] args) {
		int[] array = {2,2,3,1,4,5,6};
		smallDuiSort(array);
	}
	
	public static void smallDuiSort(int[] array) {
		heapIntial(array, 0);
		
	}
	
	public static void heapIntial(int[] array, int start_index) {
		int parent=0;	
		while(start_index>0) {
			parent =  start_index/2;
			if(array[parent]>array[start_index]) {
				swap(array, parent, start_index);
				start_index = parent;
			}else {
				break;
			}
		}
	}
	
	public static void heapModify(int[] array, int startIndex, int heapSize) {
		int smallest = startIndex;
		int left = startIndex*2;
		int right = startIndex*2+1;
		while(left<heapSize) {
			if(array[left] > array[smallest]) {
				smallest = left;
			}
			if(right<heapSize&&array[right] > array[smallest]) {
				smallest = right;
			}
			if(smallest!=startIndex) {
				swap(array, smallest, startIndex);
				startIndex = smallest;
				left = startIndex*2;
				right =  startIndex*2+1;
			}else {
				break;
			}
		}
	}
	public static void swap(int[] array, int indexA,int indexB) {
		int temp;
		temp =  array[indexA];
		array[indexA]= array[indexB];
		array[indexB] = temp;
	}
	
	public static void showArray(int[] array) {
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]+",");
		}
		System.out.println();
	}
}

