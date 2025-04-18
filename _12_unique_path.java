package dp_Striver;

import java.util.*;

public class _12_unique_path {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		System.out.println(solution1(m - 1 , n - 1));
		int[][] dp = new int[m][n];
		for(int i = 0;i<dp.length;i++) {
			Arrays.fill(dp[i] , -1);
		}
		System.out.println(solution2(m-1, n-1, dp));
		int[][] dp2 = new int[m][n];
		for(int i = 0;i<dp2.length;i++) {
			Arrays.fill(dp2[i] , -1);
		}
		System.out.println(solution3(m, n, dp2));
		
	}
//	TC = O(2^m*n) SC = O(m-1) + O(n-1) //recursive tech-space
	private static int solution1(int m,int n) {
		if(m == 0 && n == 0)	return 1;
		if(m<0 || n<0)	return 0;
		int top = solution1(m-1 , n);
		int left = solution1(m , n-1);
		return top + left;
	}
//	TC = O(m*n) SC = O(m-1) + O(n-1) //recursive tech-space + O(m*n) // dp array
	private static int solution2(int m , int n,int[][] dp) {
		if( m == 0 && n == 0) return 1;
		if(m<0 || n<0)	return 0;
		if(dp[m][n] != -1)	return dp[m][n];
		int top = solution2(m-1,n,dp);
		int left = solution2(m,n-1,dp);
		return dp[m][n] = top + left;
//		return 0;
	}
	private static int solution3(int m , int n , int[][] dp) {
		dp[0][0] = 1;
		for(int i = 0;i<m;i++) {
			for(int j= 0;j<n;j++) {
				if(i==0 && j==0)	continue;
				int left = 0,top =0;
				if(i>0)	left = dp[i-1][j];
				if(j>0) top = dp[i][j-1];
				
				dp[i][j] = left + top;
			}
		}
		return dp[m-1][n-1];
	}

}
