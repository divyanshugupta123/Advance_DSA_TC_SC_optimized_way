package dp_Striver;

import java.util.*;

public class _13_unique_path_2_LC_63 {
	static int mod = 1000000007;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[][] arr = new int[m][n];
		for(int i = 0;i<m;i++) {
			for(int j = 0;j<n;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		System.out.println(solution1(arr, m - 1, n-1));
		int[][] dp = new int[m][n];
		for(int i = 0;i<m;i++) {
			Arrays.fill(dp[i], -1);
		}
		System.out.println(solution2(arr, m-1, n-1, dp));
		int[][] dp2 = new int[m][n];
		for(int i = 0;i<m;i++) {
			Arrays.fill(dp2[i], -1);
		}
		System.out.println(solution3(arr, dp2));
	}
	private static int solution1(int[][] arr, int m ,int n) {
		if(m>=0 && n>=0 && arr[m][n] == 1) return 0;
		if(m==0 && n == 0) return 1;
		if(m<0 || n<0) return 0;
		int top = solution1(arr,m-1,n);
		int left = solution1(arr, m, n-1);
		return (top + left) % mod;
		
		
//		return 0;
		
	}
	private static int solution2(int[][] arr, int m , int n , int[][] dp) {
		if(m>=0 && n>=0 && arr[m][n] == 1)	return 0;
		if(m == 0 && n == 0) return 1;
		if(m<0 || n<0)	return 0;
		if(dp[m][n]!=-1)	return dp[m][n];
		int top = solution2(arr, m-1, n, dp);
		int left = solution2(arr, m, n-1, dp);
		return dp[m][n] = (top + left) % mod;
		
	}
	private static int solution3(int [][] arr, int[][] dp) {
		dp[0][0] = 1;
		for(int i = 0;i<arr.length;i++) {
			for(int j = 0;j<arr[0].length;j++) {
				if(i == 0 && j == 0)	continue;
				else if(arr[i][j] == 1)	dp[i][j] = 0;
				else {
					int top = 0 , left = 0;
					if(i>0)		top = dp[i-1][j];
					if(j>0)     left = dp[i][j-1];
					dp[i][j] = top + left;
				}
			}
		}
		return dp[arr.length-1][arr[0].length-1];
		
	}

}
