package study_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Study_5 {

	public static void main(String[] args) throws IOException {
		// 양의 정수 n이 입력되면 2개 이상의 연속된 자연수의 합으로 정수 n을 표현하는 가짓수 출력.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		br.close();
		
		int count=0;
		int sum=0; 
		int lt=1;
		for(int rt=1; rt<=(n/2+1); rt++) {
			// 1부터 증가하면서 더해준후 n과 같으면 카운트를 증가한다.
			sum += rt;
			if(sum==n) count++;
			
			// 더해준 값이 n보다 크거나 값다면 lt 값을 빼주고 lt 값을 증가한다.
			// lt 값을 뺀 후에도 값이 클 수 있기 때문에 while문을 이용한다.
			// 그리고 뺀 값이 n과 같을 수 있기 때문에 같다면 카운트를 증가한다.
			while(sum>=n) {
				sum -= lt++;
				if(sum==n) count++;
			}
		}
		System.out.println(count);
	}

}
