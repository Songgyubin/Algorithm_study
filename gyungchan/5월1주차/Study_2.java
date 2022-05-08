package study_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Study_2 {

	public static void main(String[] args) throws IOException {
		// 두 개의 배열이 주어지면 공통 원소를 추출하여 오름차순으로 출력하는 프로그램 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			a[i]=Integer.parseInt(st.nextToken());
		}

		int m = Integer.parseInt(br.readLine());
		int[] b = new int[m];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<m; i++) {
			b[i]=Integer.parseInt(st.nextToken());
		}
		
		// a, b배열을 오름차순으로 먼저 정렬해준다.
		Arrays.sort(a);
		Arrays.sort(b);
		ArrayList<Integer> answer = new ArrayList<>();
		int p_a=0;
		int p_b=0;
		// 두 배열을 확인하면서 a배열의 값이 작으면 a배열 인덱스를 증가, 반대면 b배열 인덱스 증가
		// 두 값이 같으면 list에 추가하여주고, 두 배열의 인덱스 아무거나를 하나 증가시킨다.
		while(p_a<n && p_b<m) {
			if(a[p_a] < b[p_b]) p_a++;
			else if(a[p_a] > b[p_b]) p_b++;
			else {
				answer.add(a[p_a]);
				p_a++;
			}
		}
		
		for(int x : answer) {
			System.out.print(x+" ");
		}
	}

}
