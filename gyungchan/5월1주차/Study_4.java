package study_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Study_4 {

	public static void main(String[] args) throws IOException {
		// n개의 수로 이루어진 수열에서 연속 부분수열의 합이 m이 되는 경우가 몇 번 있는지 구하는 프로그램 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		br.close();
		
		int lt=0;
		int rt=0;
		int sum=0;
		int count=0;
		while(rt<arr.length) {
			// 수열의 인덱스를 하나씩 올리면서 더해준다.
			sum += arr[rt++];
			// 만약 더한 값이 m이라면 카운트 증가. 
			if(sum==m) count++;
			
			// 만약 더한 값이 m보다 크거나 같다면 m보다 작아질때까지 lt 인덱스 값을 빼준다.
			// lt 인덱스 값을 빼줄때 또한 m과 같아질 수 있기 때문에 계속 m과 같은지 확인하도록 한다.
			while(sum>=m) {
				sum -= arr[lt++];
				if(sum==m) count++;
			}
		}
		System.out.println(count);
	}

}
