package RememberTest;

//使用钱币个数最小，也不包含重复最好，可以使用任意张
public class ProblemThree {
    public static void main(String[] args) {
		int[] charge = {1,2,2,3,4,5};
		int target = 8;
		System.out.println(numberOfcharge(charge, target));
	}
    
    public static int numberOfcharge(int[] chargeMoney, int target) {
    	int[] moneyNumber = new int[target+1];
    	
    	for(int i=1;i<=target;i++) {
    		moneyNumber[i] = i-chargeMoney[0]>=0?moneyNumber[i-chargeMoney[0]]+1:Integer.MAX_VALUE;
    	}
    	for(int i=1;i<chargeMoney.length;i++) {
    		for(int j=1;j<moneyNumber.length;j++) {
    		    moneyNumber[j] = Math.min(j-chargeMoney[i]>=0?moneyNumber[j-chargeMoney[i]]+1:moneyNumber[j], moneyNumber[j]); 
    		}
    	}
    	return moneyNumber[target];

    }
}
