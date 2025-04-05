package dp_Striver;
import java.util.*;
public class _3_frog_jump_problem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		problem link : https://takeuforward.org/data-structure/dynamic-programming-frog-jump-dp-3/
		
		Scanner sc = new Scanner(System.in);
		int[] arr = {30,10,60,10,60,50}; 
		System.out.println(solution1(arr, arr.length-1));
		int[] dp = new int[arr.length];
		Arrays.fill(dp, -1);
//		System.out.println(solution2(arr,arr.length-1,dp));
		System.out.println(solution3(arr,arr.length-1,dp));
		

	}
//	using recursive approach
	private static int solution1(int[] arr,int index) {
		if(index == 0)	return 0;
		int left = solution1(arr,index-1) + Math.abs(arr[index] - arr[index-1]);
		int right = Integer.MAX_VALUE; 
		if(index > 1) 	right = solution1(arr, index - 2) + Math.abs(arr[index] - arr[index - 2]);
		return Math.min(left, right);
	}
//	using memoization 
	private static int solution2(int[] arr, int index,int[] dp) {
		if(index == 0)	dp[0] = 0;
		if(dp[index]!=-1)	return dp[index];
		int left = solution2(arr,index-1,dp) + Math.abs(arr[index]-arr[index-1]);
		int right = Integer.MAX_VALUE;
		if(index>1)		right = solution2(arr,index-2,dp) + Math.abs(arr[index]-arr[index-2]);
		dp[index] = Math.min(left, right);
		return dp[index];
		
//		return 0;
	}
//	using tabulation
	private static int solution3(int[] arr,  int index , int[] dp) {
		dp[0] = 0;
		dp[1] = Math.abs(arr[0]-arr[1]);
		for(int i = 2;i<arr.length;i++) {
			int jumpOne = dp[i - 1] + Math.abs(arr[i] - arr[i - 1]);
	        int jumpTwo = dp[i - 2] + Math.abs(arr[i] - arr[i - 2]);
	        dp[i] = Math.min(jumpOne, jumpTwo); 
		}
		
		
		return dp[index];
	}

}
