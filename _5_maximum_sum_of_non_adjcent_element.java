package dp_Striver;

import java.util.*;

public class _5_maximum_sum_of_non_adjcent_element {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,1,4,9};
		System.out.println(solution1(arr, arr.length-1));
		int[] dp = new int[arr.length];
		Arrays.fill(dp, -1);
//		System.out.println(solution2(arr, dp, arr.length-1));
		System.out.println(solution3(arr, dp, arr.length-1));
		System.out.println(solution4(arr));
	}
//	Using recursion TC = O(2^n) SC = O(n) // recursive stack
	private static int solution1(int[] arr,int idx) {
		if(idx==0)	return arr[idx];
		if(idx<0)	return 0;
		int pick = arr[idx] + solution1(arr,idx-2);
		int notPick = solution1(arr,idx-1);
		return Math.max(pick, notPick);
	}
//	Using MEMOIZATION TC = O(n) and SC = O(n) + O(n)
	private static int solution2(int[] arr , int[] dp, int idx) {
		if(idx == 0)	dp[0] = arr[idx];
		if(idx<0)	return 0;
		if(dp[idx]!=-1)	return dp[idx];
		int pick = arr[idx] + solution2(arr,dp,idx-2);
		int notPick =  solution2(arr,dp,idx-1);
		return dp[idx] = Math.max(pick, notPick);
	}
//	using tabulation TC = O(n) and SC = O(n) // only DP array
	private static int solution3(int[] arr , int[] dp, int idx) {
		dp[0] = arr[0];
		if(arr.length>1)
			dp[1] = Math.max(arr[0], arr[1]);
		
		for(int i = 2;i<=idx;i++) {
			int pick = arr[i] + dp[i-2];
			int notPick = dp[i-1];
			dp[i] = Math.max(pick, notPick);
			
		}
		return dp[idx];
	}
//	space optimizing approach
	private static int solution4(int[] arr) {
		int PoP = 0;
		int prev = arr[0];
		int max = Integer.MIN_VALUE;
		for(int i = 1;i<arr.length;i++) {
			int pick = arr[i] + PoP;
			int notPick = prev;
			max = Math.max(notPick,pick);
			PoP = prev;
			prev = max;
		}
		return prev;
	}

}
