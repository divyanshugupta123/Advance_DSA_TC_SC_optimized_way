package dp_Striver;

import java.util.*;

public class fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n =  sc.nextInt();
//		System.out.println(fibo1(n));
		int[] dp = new int[n+1];
		Arrays.fill(dp, -1);
//		System.out.println(fibo2(n,dp));
//		System.out.println(fibo3(n,dp));
		System.out.println(fibo4(n));
		
	}
//	using recursive solution time complexity = O(2^n) space complexity = O(n) //Recursive stack
	private static int fibo1(int n) {
		if(n==0 || n==1)	return n;
		return fibo1(n-1)+fibo1(n-2);
	}
	
//	using DP Memoization Top-Down approach TC = O(n) and SC = O(n) + O(n) // recursive + array
	private static int fibo2(int n,int[] dp) {
		if(n==0 || n==1)	return dp[n] = n;
		if(dp[n]!=-1)	return dp[n];
		return dp[n] = fibo2(n-1,dp)+ fibo2(n-2,dp);
	}
	
//	using DP tabulation method bottom-up approach TC = O(n) and SC = O(n) // array
	private static int fibo3(int n,int[] dp) {
		dp[0] = 0;
		dp[1] = 1;
		for(int i = 2;i<=n;i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		return dp[n];
	}

//	DP space optimization TC = O(n) and SC = O(1)
	private static int fibo4(int n) {
		int PoP = 0, prev = 1;
		for(int i = 2;i<=n;i++) {
			int current = prev+PoP;
			PoP = prev;
			prev = current;
		}
		return prev;
	}

}
