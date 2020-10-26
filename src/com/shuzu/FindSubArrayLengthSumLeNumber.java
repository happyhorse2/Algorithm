package com.shuzu;
//无序数组中有正有负，求小于等于给定值的最长子数组长度


public class FindSubArrayLengthSumLeNumber {
	public static void main(String[] args) {
		
	}
	public static int getSubArrayLength(int[] arr, int value) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		//辅助数组，以左侧为开始的最大累加数组值
		int[] h = new int[arr.length+1];
		h[0] = 0;
		int sum = 0;
		for(int i=0;i<arr.length ;i++) {
			sum = sum+arr[i];
			h[i+1] = Math.max(sum, h[i]);
		}
		sum = 0;
		int res = 0;
		int pre = 0; //比arr中的索引大一个
		int len = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum+i;
			pre =  getIndexInH(arr, 0, i+1, value);
			len = pre == -1 ? 0 : i-pre+1;
			res = Math.max(res, len);
		}
		return res;
		
	}
	public static int getIndexInH(int[] arr ,int start, int end, int value) {
		int res = -1;
		//代表为在start，end间未发现大于等于与value的数
		int mid = 0;
		while(start<=end) {
			mid =  (start + end)/2;
			if (arr[mid]>=value) {
				res = mid;
				mid = end -1;
			}else {
				mid = start+1;
			}
		}
		return res;
	}
}
