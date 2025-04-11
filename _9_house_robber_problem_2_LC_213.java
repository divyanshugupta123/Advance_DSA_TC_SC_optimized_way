package dp_Striver;

import java.util.*;

public class _9_house_robber_problem_2_LC_213 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0;i<n;i++) 
			arr[i] = sc.nextInt();
		int[] a = new int[n-1];
		int[] b = new int[n-1];
		for(int i = 0;i<n-1;i++) 
			a[i] = arr[i];
		for(int i = 1;i<n;i++)
			b[i-1] = arr[i];
//		System.out.println(Math.max(solution1(a, a.length-1), solution1(b, b.length-1)));
		int[] dp1 = new int[n-1];
        Arrays.fill(dp1,-1); 
        int[] dp2 = new int[n-1];
        Arrays.fill(dp2,-1); 
		// return Math.max(solution2(a, a.length-1,dp1), solution2(b, b.length-1,dp2));
        // return Math.max(solution3(a, a.length-1,dp1), solution3(b, b.length-1,dp2));
        System.out.println(Math.max(solution4(a), solution4(b)));
		
	}
	private static int solution1(int[] arr,int idx) {
		if(idx==0)	return arr[idx];
		if(idx<0) return 0;
		
		int left = arr[idx] + solution1(arr,idx-2) ;
		int right = solution1(arr,idx-1);
		return Math.max(left,right);
		
	}
	
    private static int solution2(int[] arr, int idx,int[] dp){
        if(idx == 0)    dp[0] = arr[0];
        if(idx<0) return 0;
        if(dp[idx] != -1) return dp[idx];
        int pick = arr[idx] + solution2(arr,idx-2,dp);
        int notPick = solution2(arr,idx-1,dp);
        return dp[idx] = Math.max(pick,notPick);
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
