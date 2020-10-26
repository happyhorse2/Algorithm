package com.shuzu;

//找出无序数组中最小的K个数，原理是堆排序
public class FindNumberOfKInunsortArray {
	public static void main(String[] args) {
	
	}
	public static int[] getKMinNumberByHeap(int[] arr, int k) {
		if(k< 1 ||  k>arr.length ) {
			return arr;
		}
		int[] KHeap = new int[k];
		FormHeap(KHeap);
		for (int i = k; i < arr.length; i++) {
			if(arr[i]< KHeap[0]) {
				KHeap[0] = arr[i];
				HeapModify(KHeap, 0, k);
			}
		}
		return KHeap;
		
	}
	//将数组构建成大根堆，构造K个数的大根堆
	public static void FormHeap(int[] KHeap){
		for(int i=0; i<KHeap.length; i++) {
			HeapInsert(KHeap, i);
		}
	}
	//将数组中的数从0进行大根堆调整
	public static void HeapInsert(int[] KHeap, int index) {
		while(index>0) {
			int parent = (index-1)/2;
			if (KHeap[parent] < KHeap[index]) {
				swap(KHeap, index, parent);
				index = parent;
			}
			else {
				break;
			}
		}
	}

	public static void HeapModify(int[] KHeap, int start_index,int HeapSize) {
		//通过left判断是否超出堆的界限
		int left = start_index*2+1;
		int right = start_index*2+2;
		int largest = start_index;
		while(left<HeapSize) {
			if (KHeap[left] > KHeap[start_index]) {
				largest = left;
			}
			if (right<HeapSize && KHeap[right] > KHeap[largest]) {
				largest = right;
			}
			//如果相等break
			if(largest == start_index) {
				break;
			}
			swap(KHeap, largest, start_index);
			start_index = largest;
			left = start_index*2+1;
			right = start_index*2+2;
		}
	}
	public static void swap(int[] arr, int index1,int index2) {
		int tmp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2]= tmp;
	}
}
