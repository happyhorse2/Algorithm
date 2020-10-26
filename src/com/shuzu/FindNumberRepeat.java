package com.shuzu;

import java.nio.channels.NetworkChannel;

public class FindNumberRepeat {
   public static void main(String[] args) {
	    int[] numbers = {1,2,2};
	    int[] duplication = new int[1];
	    duplicate(numbers, numbers.length, duplication);
   }
   public static boolean duplicate(int numbers[],int length,int [] duplication) {
       int i=0;
       int temp = -1;
       boolean result = false;
       while(i<length){
           if(i==numbers[i]){
               i++;
           }else{
        	   System.out.println(numbers[numbers[i]]+"bbbb"+numbers[i]+"ccc"+i);
               if(numbers[numbers[i]]==numbers[i]){
                   duplication[0]=numbers[i];
                   result = true;
                   break;
               }
               else{
                   temp = numbers[numbers[i]];
                   numbers[numbers[i]]=numbers[i];
                   numbers[i] = temp;
               }
           }
       }
       return result;
  }
   
   public boolean duplicatev2(int numbers[],int length,int [] duplication) {
       int i=0;
       int temp = -1;
       boolean result = false;
       while(i<length) {
           if(i==numbers[i]){
               i++;
           }else{
               if(numbers[numbers[i]]==numbers[i]){
                   duplication[0]=numbers[i];
                   result = true;
                   break;
               }
               else{
                   temp = numbers[numbers[i]];
                   numbers[numbers[i]] = numbers[i];
                   numbers[i] = temp;
               }
           }
       }
       return result;
  }
  public static void swap(int[] numbers, int i, int j) {
	  int temp = numbers[i];
	  numbers[j] = numbers[i];
	  numbers[i] = temp;
  }
}
