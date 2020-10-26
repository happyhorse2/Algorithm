package com.special;
public class FindOneNumber {
    public static void main(String[] args) {
		int result = findNumber(534);
		System.out.print(result);
	}
    
    public static int findNumber(int n) {
    	if(n==0){
            return 0;
        }
        int base=1;
        int count=0;
        int round =n;
        int weight = 0;
        while(round>0){
            weight = round%10;//所求位的余数
            round = round/10;
            count = round*base+count; //每向前移动都是需要看base的
            if(weight==1){
                count = count+n%base+1;
            }
            else if(weight>1){
                count = count+base;
            }
            base=base*10;
        }
        return count;
    }
}
