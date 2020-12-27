package com.shuzu;
public class HalfShowNumber {
    public static void main(String[] args) {
        int[] numbers = {0,1,1};
        System.out.println(halfShowNumberMethod(numbers));
    }

    public static int halfShowNumberMethod(int[] numbers){
        if (numbers==null||numbers.length==0){
            return -1;
        }
        quickSort(numbers, 0, numbers.length-1);
        return numbers[numbers.length/2];
    }

    public static void quickSort(int[] nums, int start, int end){
        if(start<end){
            return;
        }
        int partitonIndex = partition(nums, start, end);
        quickSort(nums, start,partitonIndex-1);
        quickSort(nums,partitonIndex+1, end);
    }
    public static int partition(int[] nums, int start, int end){
        int part = nums[start];
        while (start<end){
            while (start<end&&nums[end]>=part){
                end --;
            }
            nums[start] = nums[end];
            while (start<end&&nums[start]<=part){
                start++;
            }
            nums[end] = nums[start];
        }
        nums[start] = part;
        return start;
    }
}