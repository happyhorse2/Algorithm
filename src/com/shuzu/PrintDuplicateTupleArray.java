package com.shuzu;



public class PrintDuplicateTupleArray {
	public static void main(String[] args) {
		int[] arrays = new int[] {-8,-4,-3,0,1,2,4,5,8,9};
		twoTupleSum(arrays, 10);
		System.out.println();
		threeTupleSum(arrays, 10);
	}
	// 在排序数组中，不重复的打印，相加和等于定值的二元组
	public static void twoTupleSum(int[] arr, int value) {
		int left = 0;
		int right = arr.length-1;
		while(left<right) {
			if(arr[left]+ arr[right] == value) {
				if (left==0 || arr[left-1] != arr[left]) {
					System.out.print("("+arr[left]+","+arr[right]+")");
				}
				left++;
				right--;
			}else if(arr[left]+ arr[right] > value){
				right--;
			}else {
				left++;
			}
		}
	}
	
	public static void threeTupleSum(int[] arr, int value) {
		for (int i = 0; i < arr.length; i++) {
        	//选定三元组的第一个值不重复
			if (i==0 || arr[i] != arr[i-1]) { //头部元素或者不重复可打印
				printTest(arr, i, i+1, arr.length-1, value-arr[i]);
			}
		}
	}
	public static void printTest(int[] arr, int start, int left, int right, int value) {
		while(left< right) {
			if(arr[left]+arr[right]<value) {
				left++;
			}else if(arr[left]+arr[right]>value) {
				right--;
			}else {
				if (start+1 == left|| arr[left]!=arr[left-1]) {//头部元素满足不向后判断,再次判断不重复打印
					System.out.print("("+arr[start]+","+arr[left]+","+arr[right]+")");
				}
				left++;
				right--;
			}
		}
	}
}
