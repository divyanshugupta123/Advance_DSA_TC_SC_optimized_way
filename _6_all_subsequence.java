package dp_Striver;

import java.util.*;

public class _6_all_subsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0;i<arr.length;i++) {
			arr[i] = sc.nextInt();
		}
		printAllSubsequences(arr, 0, new ArrayList<>());
		
	}
	private static void printAllSubsequences(int [] arr,int idx,List<Integer> list) {
		if(idx >= arr.length){
			System.out.println(list);
			return;
		}
		list.add(arr[idx]);
		printAllSubsequences(arr, idx + 1, list);
		list.remove(list.size()-1);
		printAllSubsequences(arr, idx + 1, list);
	}

}
