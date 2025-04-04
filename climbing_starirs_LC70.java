package dp_Striver;
import java.util.*;

public class climbing_starirs_LC70 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub  
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		// return solution1(n,0);
        int[] dp = new int[n + 1]; 
        Arrays.fill(dp, -1);
        // return solution2(n,0,dp);
        // return solution3(n,n,dp);
        System.out.println(solution4(n));
		

	}
    // recursive approach gives TLE
    private static int solution1(int n,int sum){
        if(sum == n)    return 1;
        if(sum>n)   return 0;
        int l = solution1(n,sum+1);
        int r = solution1(n,sum+2);
        return l+r;
    }
    // using DP memoization 
    private static int solution2(int n,int sum,int[] dp){
        if(sum==n)  return 1;
        if(sum > n) return 0;
        if(dp[sum]!=-1) return dp[sum];
        int l = solution2(n,sum+1,dp);
        int r = solution2(n,sum+2,dp);
        return l+r;
    }
    // DP tabulation method bottom - up
    private static int solution3(int n, int sum,int[] dp){
        dp[0] = 1;
        if(sum>=1)  dp[1] = 1;
        for(int i = 2;i<=n;i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];

    }

    // space optimization 
    public static int solution4(int n){
        if(n==0 || n == 1)  return 1;
            
        int pop = 1,prv = 1;
        for(int i = 2;i<=n;i++){
            int current = pop+prv;
            pop = prv;
            prv = current;
        }
        return prv;
    }

}