package study_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Study_3 {

	public static void main(String[] args) throws IOException {
		// n일 동안의 매출기록을 보여주고 연속된 k일 동안의 최대 매출액은 얼마인지 출력하는 프로그램.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		br.close();
		for(int i=0; i<n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		// 먼저 k일 동안의 매출액을 저장한다.
		int sum=0;
		for(int i=0; i<k; i++) {
			sum+=arr[i];
		}
		
		int max=sum;
		int i = k;
		// 그 다음날 값의 매출액을 더하고 첫째날에 값을 빼주면서 매출액을 저장한다.
		// 매출액이 더 큰 값을 출력.
		while(i<arr.length) {
			sum += arr[i]-arr[i-k];
			if(sum>max) max=sum;
			i++;
		}
		System.out.println(max);
	}

}
