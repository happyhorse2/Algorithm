package com.dynamic;
//青蛙一次可以跳一个台阶，或两个台阶,或者3个，或者 .....个台阶，求青蛙跳到n阶台阶共有多少种跳法

import java.awt.image.RescaleOp;

public class BianTaiTiaoTaijie {
	public static void main(String[] args) {
		
	}
	
	public static int JumpFloorII(int target) {
        int res = 0;
		if(target==0) {
            return 0;
        }
		if(target==1) {
        	return 1;
        }
        res = 2*JumpFloorII(target-1);
        return res;
	}
	
}
