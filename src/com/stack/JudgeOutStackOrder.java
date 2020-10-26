package com.stack;

import java.util.Stack;

//给定两个序列，a,b判断b是否是a的出栈顺序
public class JudgeOutStackOrder {
	public static void main(String[] args) {
		int[] push = {1,2,3,4,5};
		int[] pop = {5,4,3,2,1};
		System.out.println(JudgeOutStackOrderMethod(push, pop));
	}
	
	public static boolean JudgeOutStackOrderMethod(int[] push, int[] pop) {
		boolean res;
		if(push==null||pop==null) {
			res = false;
		}
		int popstart = 0;
		Stack<Integer> stack = new Stack<Integer>();
 		for(int i=0;i<push.length;i++) {
			stack.push(push[i]);
			while(!stack.isEmpty()&&stack.peek()==pop[popstart]) {
				stack.pop();
				popstart++;
			}
		}
 		res = stack.isEmpty();
 		return res;
	}
}
