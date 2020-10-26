package com.shuzu;
//将一个数组的奇数，都移动到左边，偶数都移动到右边
public class PartJiShuOuShu {
	public static void main(String[] args) {
		int[] array = {3,1,4,5,2,4,7};
		changeShuZhuMethod(array);
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]);
		}
	}
	
	public static void changeShuZhuMethod(int[] array) {
		if(array==null||array.length==0) {
			return ;
		}
		int begin = 0, from =-1; //指向第一个偶数的位置
		while (begin<array.length) {
			while(begin<array.length&&array[begin]%2!=0) {
				begin++;
			}
			from = begin + 1; //指向第一个奇数的位置
			while(from<array.length&&array[from]%2==0) {
				from++;
			}
			System.out.println(begin+","+from);
			if(from<array.length) {
				int temp = array[from];
				for(int i = from-1; i>=begin; i--){
					array[i+1] = array[i]; 
				}
				array[begin++] = temp;
			}else {
				break;
			}
		}
	}
}
