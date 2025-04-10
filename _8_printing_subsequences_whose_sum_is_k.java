package dp_Striver;

import java.util.*;

public class _8_printing_subsequences_whose_sum_is_k {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] arr = new int[n];
		for(int i = 0;i<arr.length;i++) {
			arr[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		solution1(arr,0,0,k,new ArrayList<>());
		
		
	}
	private static void solution1(int[] arr,int idx,int sum,int k,List<Integer> list) {
		if(idx>=arr.length) {
			if (sum == k) {
				System.out.println(list);
			}
			return;
		}
		
		if(sum>k) {
			return;
		}
		list.add(arr[idx]);
		solution1(arr,idx+1,sum+arr[idx],k,list);
		list.remove(list.size()-1);
		solution1(arr,idx+1,sum,k,list);
	}

}
