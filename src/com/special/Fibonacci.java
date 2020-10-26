package com.special;

public class Fibonacci {
    public static void main(String[] args) {
		System.out.print(FibonacciMethod(3));
	}
    public static int FibonacciMethod(int n) {
        int a=0, b=1, c=0; 
        if (n==0){
             return 0;
         }
         else if(n==1){
             return 1;
         }
        for(int i=2;i<=n;i++){
            c = a+b;
            a=b;
            b=c;
        }
        return c;
    }
}
