package study_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Study_1 {

	public static void main(String[] args) throws IOException {
		// 오름차순으로 정렬된 두 배열을 합쳐서 하나의 오름차순 배열로 만드는 프로그램 
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
		
		ArrayList<Integer> answer = new ArrayList<>();
		// 각각 p_a는 a배열의 처음 인덱스를, p_b는 b 배열의 처음 인덱스를 가르킨다.
		int p_a=0;
		int p_b=0;
		// a와 b의 값을 비교하여 작은 것을 먼저 새로 생성한 배열에 입력해주고,
		// 더 작은 값이 있었던 배열의 인덱스를 하나 증가시켜주는 식으로 진행한다.
		while(p_a<a.length && p_b<b.length) {
			if(a[p_a] < b[p_b]) {
				answer.add(a[p_a]);
				p_a++;
			}
			else {
				answer.add(b[p_b]);
				p_b++;
			}
		}
	
		// a, b 배열 중 어느 배열에 값들이 더 남았는지 모르기 때문에 한번씩 다시 실행해준다.
		while(p_a<a.length) {
			answer.add(a[p_a]);
			p_a++;
		}
		while(p_b<b.length) {
			answer.add(b[p_b]);
			p_b++;
		}
		
	
		for(int x : answer) {
			System.out.print(x+" ");
		}
	}

}
