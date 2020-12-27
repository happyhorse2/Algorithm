package com.special;

public class TwoNumberAdd {
    public static void main(String[] args) {
        int number1 = 10;
        int number2 = 12;
        while (number2!=0){
            int temp = number1^number2;//no jinwei
            number2 = (number1&number2)<<1; //jinwei result qianyi.
            number1 = temp;
        }
        System.out.print(number1);
    }
}
