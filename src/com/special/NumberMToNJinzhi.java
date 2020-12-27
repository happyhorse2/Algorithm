package com.special;

import com.sun.xml.internal.ws.encoding.MtomCodec;

//m
public class NumberMToNJinzhi {
   public static void main(String[] args) {
       int m =1000;
       int n = 5;
       System.out.println(MToN(-1000, 5));
   }
   public static String MToN(int m, int n){
       boolean flag = true;
       if(m==0){
        return "0";
       }
       if(m<0){
           flag = false;
           m=-m;
       }
       String result="";
       StringBuffer res = new StringBuffer();
       while (m!=0){
           res.append(m%n);
           m=m/n;
       }
       result =  flag ? res.reverse().toString(): "-"+res.reverse().toString();
       return result;
   }
}