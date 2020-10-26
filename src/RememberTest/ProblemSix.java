package RememberTest;

import sun.tools.jar.resources.jar;

public class ProblemSix {
  public static void main(String[] args) {
	
  }
  
  public static int[] mostLength() {
	  int[] array1 = {12,3,4,5,6,78};
	  int[] array2 = {2,3,4,5,6,223};
	  int[][] matrix = new int[array1.length][array2.length];
	  for(int i=0;i<array2.length;i++) {
		  if(array1[0]==array2[i]) {
			  matrix[0][i] = 1;
		  }
	  }
	  for(int j=0;j<array1.length;j++) {
		  if(array2[0]==array1[j]) {
			  matrix[j][0] = 1;
		  }
	  }
	  for(int i=1;i<array1.length;i++) {
		  for(int j=1;j<array2.length;j++) {
			  matrix[i][j] = Math.max(matrix[i-1][j], matrix[i][j-1]);
			  if(array1[i]==array2[j]) {
				  matrix[i][j] = Math.max(matrix[i][j], matrix[i-1][j-1]+1);
			  }
		  }
	  }
	  int k = matrix[array1.length-1][array2.length-1]-1;
	  int[] result = new int[k];
	  int h=0, i=array1.length-1, j=array2.length-1;
	  while(i>=0&&j>=0) {
		  if(matrix[i][j]==matrix[i-1][j]) {
			  i--;
		  }else if (matrix[i][j]==matrix[i][j-1]) {
			  j--;
		  }else {
			  result[k--] = array1[i];
			  i--;
			  j--;
		  }
	  }
	  return result;
  }
  
  public static int[] mostLengh() {
	  int[] array = {1,2,34,4,5,6,2,6,2};
	  int[] dp = new int[array.length];
	  int maxlength = 0, index=0;
	  for(int i=0;i<array.length;i++) {
		  dp[i]=1;
		  for(int j=0;j<i;j++) {
			  if(dp[j]<dp[i]) {
				  dp[i]=Math.max(dp[j]+1, dp[i]);
			  }
		  }
		  if(dp[i]>maxlength) {
			  maxlength = dp[i];
			  index = i;
		  }		  
	  }
	  int[] result = new int[maxlength];
	  result[--maxlength] = dp[index];
	  for(int i=index;i>=0;i--) {
		  if(array[i]<array[index]&&dp[i]+1==dp[index]) {
			  result[--maxlength] = array[i];
			  index = i; 
		  }
	  }
	  return result;
  }
}
