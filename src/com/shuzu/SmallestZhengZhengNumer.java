package com.shuzu;


//在一个数组中的找到未出现最小正整数
public class SmallestZhengZhengNumer {
	public static void main(String[] args) {
		int[] arrays = {-1, 3, 2, 7, 1};
		System.out.print(SmallestZhengZhengNumerMethod(arrays));
	}
	
	public static int SmallestZhengZhengNumerMethod(int[] array) {
		int i=0;
		int j=array.length;
		while(i<j) {
			if(array[i]== i+1) {
				i++;  //在理想的位置，（array[i]在array[i]-1的位置上时正确的，说明重复，无效数据）
			}else if(array[i]>j || array[i]<=i || array[array[i]-1]==array[i]) {
				array[i]=array[--j]; //非法数据，将最后的拿到前面，重新赋值
			}
			else {
				swap(array, i, array[i]-1); //array[i]合法但是没有在合适的位置上
			}
		}
		return i+1;
	}
	public static void swap(int[] array, int i, int j) {
		int temp;
		temp =  array[i];
		array[i] = array[j];
		array[j] = temp; 
	}
}
