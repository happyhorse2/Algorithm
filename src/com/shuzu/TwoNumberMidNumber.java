package com.shuzu;
//
public class TwoNumberMidNumber {
    public static void main(String[] args) {
        int[] numbers1 = {1,2,3,4};
        int[] numbers2 = {3,4,5,6};
        System.out.println(findMedianinTwoSortedAray(numbers1, numbers2));
        
    }
    public static int findMedianinTwoSortedAray (int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length+arr2.length];
        int arr1Index = 0, arr2Index = 0;
        int resultIndex = 0;
        while (arr1Index<arr1.length&&arr2Index<arr2.length){
            if(arr1[arr1Index]<=arr2[arr2Index]){
                result[resultIndex++]=arr1[arr1Index++];
            }else {
                result[resultIndex++] = arr2[arr2Index++];
            }
        }
        if(arr1Index==arr1.length){
            while (arr2Index<arr2.length){
                result[resultIndex++]=arr2[arr2Index++];
            }
        }
        if(arr2Index==arr2.length){
            while (arr1Index<arr1.length){
                result[resultIndex++]=arr2[arr1Index++];
            }
        }
        if (result.length/2==0){
            return result[result.length/2];
        }else {
            return result[result.length / 2 + 1];
        }
    }
}