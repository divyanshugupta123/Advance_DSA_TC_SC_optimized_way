package dp_Striver;
import java.util.*;
public class _4_frog_jump_kSteps_problem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] arr = {30,10,60,10,60,50};
		int k = sc.nextInt();
//		System.out.println(solution1(arr, k, arr.length-1));
		int[] dp = new int[arr.length];
		Arrays.fill(dp, -1);
//		System.out.println(solution2(arr,dp,arr.length-1,k));
		System.out.println(solution3(arr,dp,k,arr.length-1));

	}
//	using Recursive method time complexity for this problem is O(k^n) where k is the number of recursive calls
	private static int solution1(int[] arr, int k,int idx) {
		if(idx == 0)	return 0;
		int min = Integer.MAX_VALUE;
		for(int i = 1;i<=k;i++) {
			
			if(idx-i>=0) {
				int call =  solution1(arr, k, idx-i) + Math.abs(arr[idx]-arr[idx-i]);
				min = Math.min(call, min);
			}
		}
		return min;
	}
//	using Memoization method TC = O( N * K ) SC = O(N) + O(N)
	private static int solution2(int[] arr,int[] dp , int idx , int k) {
		
		if(idx == 0)	dp[0] = 0;
		if(dp[idx]!=-1) return dp[idx];
		int min = Integer.MAX_VALUE;
		for(int i = 1;i<=k;i++) {
			
			if(idx-i>=0) {
				int call =  solution2(arr, dp, idx-i,k) + Math.abs(arr[idx]-arr[idx-i]);
				min = Math.min(call, min);
			}
		}
		return dp[idx] = min;
	}
//	USING TABULATION METHOD
	private static int solution3(int[]arr,int[] dp, int k,int idx) {
		dp[0] = 0;

	    for (int i = 1; i <= idx; i++) {
	        int min = Integer.MAX_VALUE;

	        for (int j = 1; j <= k; j++) {
	            if (i - j >= 0) {
	                int jump = dp[i - j] + Math.abs(arr[i] - arr[i - j]);
	                min = Math.min(min, jump);
	            }
	        }

	        dp[i] = min;
	    }

	    return dp[idx];
	}
}
