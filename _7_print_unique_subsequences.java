package dp_Striver;

import java.util.*;

public class _7_print_unique_subsequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0;i<arr.length;i++) {
			arr[i] = sc.nextInt();
		}
		printAllSubsequences(arr, 0, new ArrayList<>(),new HashSet<>());
		
	}
	private static void printAllSubsequences(int [] arr,int idx,List<Integer> list,Set<String> set) {
		if(idx >= arr.length){
			String str = list.toString();
			if(!set.contains(str)) {
				
				System.out.println(list);
				set.add(str);

			}
			return;
		}
		list.add(arr[idx]);
		printAllSubsequences(arr, idx + 1, list,set);
		list.remove(list.size()-1);
		printAllSubsequences(arr, idx + 1, list,set);
	}
	

}
