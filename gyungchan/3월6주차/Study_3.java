package study_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Study_3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		br.close();
		
		HashMap<Integer, Integer> map = new HashMap<>();
		ArrayList<Integer> answer = new ArrayList<>();
		for(int i=0; i<k-1; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
		}
		int lt=0;
		for(int i=k-1; i<n; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
			answer.add(map.size());
			map.put(arr[lt], map.get(arr[lt])-1);
			if(map.get(arr[lt])==0) map.remove(arr[lt]);
			lt++;
		}
		for(int x : answer) {
			System.out.print(x+" ");
		}
	}

}
