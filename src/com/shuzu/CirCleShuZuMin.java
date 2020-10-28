package com.shuzu;
//旋转数组的最小数字
//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
//输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
//NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
public class CirCleShuZuMin {
    public static void main(String[] args) {

    }
    public static int minNumberInRotateArray(int [] array) {
        if(array==null||array.length==0){
            return 0;
        }
        return erFenFind(array);
    }
    public static int erFenFind(int[] array){
        int start = 0;
        int end = array.length-1;
        while (start<end){
            int mid = (start+end)/2;
            if(array[mid]<array[end]){
                end = mid;
            }else if(array[mid]>array[end]){
                start = mid+1;
            }else {
                end--;
            }
        }
        //最后start==end结束
        return array[start];
    }
}
