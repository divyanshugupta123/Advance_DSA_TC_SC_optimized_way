package dp_Striver;

import java.util.*;

public class _10_house_robber_1_LC_198 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0;i<n;i++) 
			arr[i] = sc.nextInt();
        // return Math.max(solution1(a, a.length-1), solution1(b, b.length-1));
        // gives you TLE;
        // return solution1(arr,arr.length-1);
        // using memoization
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        // return solution2(arr,arr.length-1,dp);
        // using tabulation
        // return solution3(arr,arr.length-1,dp);
         System.out.println(solution4(arr));
		
	}
    private static int solution1(int[] arr,int idx) {
		if(idx==0)	return arr[idx];
		if(idx<0) return 0;
		
		int left = arr[idx] + solution1(arr,idx-2) ;
		int right = solution1(arr,idx-1);
		return Math.max(left,right);
		
	}
    private static int solution2(int[] arr,int idx,int[] dp){
        if(idx == 0) dp[idx] = arr[0];
        if(idx<0) return 0;
        if(dp[idx]!=-1) return dp[idx];
        int left = arr[idx] + solution2(arr,idx-2,dp);
        int right = solution2(arr,idx-1,dp);
        return dp[idx] = Math.max(left, right);
    }
    private static int solution3(int[] arr, int idx,int[] dp){
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
    private static int solution4(int[] arr){
        int PoP = 0;
        int prev = arr[0];
        for(int i = 1;i<arr.length;i++){
            int pick = arr[i] + PoP;
            int notPick = prev;
            int curr = Math.max(pick,notPick);
            PoP = prev;
            prev = curr;
        }
        return prev;
    }
}