package com.dynamic;

import java.util.Scanner;

public class HanNuota {
	public static void main(String args[]){
		System.out.println("请输入要移动的块数：");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		move(n,'a','b','c');
	}
	public static void move(int n,char a,char b,char c){
		if(n==1){ //当n只有1个的时候直接从a移动到c
			System.out.println(a+"移动"+n+"-->"+c);
		}else{
			move(n-1,a,c,b);
			System.out.println(a+"移动"+n+"-->"+c);
			move(n-1,b,a,c);//第n-1个移动过来之后b变开始盘，b通过a移动到c
		}
	}
}
