package RememberTest;


//还钱的方法数，有多少种,前提是不能有重复的，货币可使用任意张
public class ProlemFour {
	public static void main(String[] args) {
		int[] charge = {2,2,4,1,5,6};
		int target = 2;
		System.out.print(method(charge,target));
	}
	public static int method(int[] charge, int target) {
		if(charge==null) {
			return 0;
		}
		int[] numberOfmethod = new int[target+1];
		numberOfmethod[0] = 1;
		for(int i=1; i<numberOfmethod.length; i++) {
			numberOfmethod[i] = i-charge[0]>=0?numberOfmethod[i-charge[0]]: 0;
		}
		for(int i=1; i<charge.length; i++) {
			for(int j=1; j<numberOfmethod.length; j++) {
				numberOfmethod[j] = numberOfmethod[j]+ (j-charge[i]>=0?numberOfmethod[j-charge[i]]:0);
			}
		}
		return numberOfmethod[target];
	}
}
