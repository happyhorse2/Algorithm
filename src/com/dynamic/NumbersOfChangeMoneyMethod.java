package com.dynamic;

//使用钱币有多少方法数
public class NumbersOfChangeMoneyMethod {
    public static void main(String[] args) {
    	int money = 3;
    	int[] chargeMoney = {1, 2};
    	int result = numbersOfMethodVersionTwoOfPress(money, chargeMoney);
    	System.out.print(result);
	}
    
    public static int numbersOfMethod(int money, int[] chargeMoney) {
    	if (money<0 || chargeMoney == null || chargeMoney.length == 0) {
    		return 0;
    	}
    	int[][] result = new int[chargeMoney.length][money+1];
    	//money， 0的时候不论多少货币只有一种情况
    	for (int i=0; i<result.length; i++) {
    		result[i][0] = 1;
    	}
    	//初始化只使用第一个货币的情况，使用第一种货币，就只有使用第一种货币的情况。
    	for (int i = 0; i*chargeMoney[0]<=money; i++) {
    		result[0][i*chargeMoney[0]] = 1;
		}
    	
    	for(int i=1; i<chargeMoney.length; i++) {
    		for(int j=1; j<=money; j++) {
        		int num = 0 ;
        		//使用i货币，可能使用1个，2个，3个等等。
    			for(int k=0; k*chargeMoney[i]<=j; k++) {
    				num = num + result[i-1][j-k*chargeMoney[i]];
    			}
    			result[i][j] = num;
    		}
    	}
    	return result[chargeMoney.length-1][money];
    }
    
    //利用使用i货币和不是用i货币两种情况
    public static int numbersOfMethodVersionTwo(int money, int[] chargeMoney) {
    	if (money<0 || chargeMoney == null || chargeMoney.length == 0) {
    		return 0;
    	}
    	int[][] result = new int[chargeMoney.length][money+1];
    	//money， 0的时候不论多少货币只有一种情况
    	for (int i=0; i<result.length; i++) {
    		result[i][0] = 1;
    	}
    	//初始化只使用第一个货币的情况
    	for (int i = 0; i*chargeMoney[0]<=money; i++) {
    		result[0][i*chargeMoney[0]] = 1;
		}
    	for(int i=1; i<chargeMoney.length; i++) {
    		for(int j=1; j<=money; j++) {
    			result[i][j] = result[i-1][j];  //一个i对应的钱币不用
    			try {
    				//开始使用i钱币
        			result[i][j] = result[i][j] + ((j-chargeMoney[i])>=0?result[i][j-chargeMoney[i]]:0);
				} catch (Exception e) {
					System.out.print("i:="+i+"j:="+j+result[i][j]+"bbb"+(j-chargeMoney[i])+"aaa"+result[i][j-chargeMoney[i]]);
				}

    		}
    	}
    	return result[chargeMoney.length-1][money];
    }
    
    public static int numbersOfMethodVersionTwoOfPress(int money, int[] chargeMoney) {
    	if (money<0 || chargeMoney==null || chargeMoney.length==0) {
    		return 0;
    	}
    	int[] result= new int[money+1];
    	//初始化只是用一种货币的情况
    	for(int i=0;i*chargeMoney[0]<=money;i++) {
    		result[i*chargeMoney[0]] = 1;
    	}
    	//计算使用多个货币的情况，result[j-chargeMoney[i]]，使用之前的货币，到达j-chargeMoney[i]有多少种方法，result[j]使用之前的货币,到达j有多少种方法
    	for(int i=1; i< chargeMoney.length; i++) {
    		for(int j=1;j<=money;j++) {
    			result[j]= result[j]+(j-chargeMoney[i]>=0?result[j-chargeMoney[i]]:0);
    		}
    	}
    	return result[money];
    }
    
 

    
}
