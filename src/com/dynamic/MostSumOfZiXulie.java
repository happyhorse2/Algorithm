package com.dynamic;

//最大子序列和
public class MostSumOfZiXulie {
	public static void main(String[] args) {
		int[] arrays = {-2, 1000, -3, 4, -1, 2, 1, -5, 4};
		int result = MostSumOfZixulieMethod(arrays);
		System.out.print(result);
	}
	
	public static int MostSumOfZixulieMethod(int[] arrays) {
		if(arrays==null || arrays.length==0) {
			return 0;
		}
		int subsum = 0;
		int maxsum = Integer.MIN_VALUE;
		for(int i=0; i<arrays.length; i++) {
			if(subsum<0) {
				subsum = arrays[i];
			}
			else{
				subsum = subsum+arrays[i];
			}
			maxsum = Math.max(subsum, maxsum);
		}
		return maxsum;
	}
}


