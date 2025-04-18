package dp_Striver;

import java.util.*;

public class _11_ninja_training_2D_DP_concept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		problem link : https://www.naukri.com/code360/problems/ninja-s-training_3621003?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos
		int[][] arr = {{2,1,3},{3,4,6},{10,1,6},{8,3,7}};
		System.out.println(solution1(arr, arr.length-1, 3));
		int[][] dp = new int[arr.length][4];
		for (int i = 0; i < arr.length; i++) {
		    Arrays.fill(dp[i], -1);
		}
//		System.out.println(solution2(arr, arr.length-1, 3, dp));
		System.out.println(solution3(arr,dp));
	}
	private static int solution1(int[][] arr, int index , int lastActivity) {
		if(index == 0) {
			int max = Integer.MIN_VALUE;
			for(int i = 0;i<=2;i++) {
				if(i!=lastActivity) {
					max = Math.max(max, arr[0][i]);
				}
			}
			return max;
		}
		int max = Integer.MIN_VALUE;
		for(int i = 0;i<=2;i++) {
			if(i != lastActivity) {
				int point = arr[index][i] + solution1(arr,index-1,i);
				max = Math.max(max, point);
			}
		}
		return max;
//		return 0;
	}
	private static int solution2(int[][] arr, int index,int last,int[][] dp) {
		if(index == 0) {
			int max = 0;
			for(int i = 0;i<=2;i++) {
				if(i != last) {
					max = Math.max(max, arr[0][i]);
				}
				dp[0][i] = max;
			}
		}
		if(dp[index][last] != -1) return dp[index][last];
		int max = 0;
		for(int i = 0;i<=2;i++) {
			if(i != last) {
				int point = arr[index][i] + solution2(arr,index-1,i,dp);
				max = Math.max(max, point);
			}
		}
		return dp[index][last] = max;
	}
	private static int solution3(int[][] arr , int[][] dp){
        dp[0][0] = Math.max(arr[0][1],arr[0][2]);
        dp[0][1] = Math.max(arr[0][0],arr[0][2]);
        dp[0][2] = Math.max(arr[0][1],arr[0][0]);
        dp[0][3] = Math.max(arr[0][0] , (Math.max(arr[0][1],arr[0][2])));
        for(int day = 1; day<arr.length;day++){
            for(int last = 0;last<4;last++){
                dp[day][last] = 0;
                for(int task = 0;task<3;task++){
                    if(task != last){
                        int point = arr[day][task] + dp[day-1][task];
                        dp[day][last] = Math.max(dp[day][last] , point);
                    }
                }
            }
        }
        return dp[arr.length-1][3];
    }

}
