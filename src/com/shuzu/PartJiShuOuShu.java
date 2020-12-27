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
		int length = array.length;
		int odd = 0;
		int even = 0;                           //even用于遍历数组使用，odd用于定位
		while (even < length){
			if(array[even]%2 != 0){
				int temp = array[even];
				for (int i = even; i>odd; i--){
					array[i] = array[i-1];
				}
				array[odd] = temp;
				odd++;
				even++;
			}else {
				even++;
			}
		}
	}
}
