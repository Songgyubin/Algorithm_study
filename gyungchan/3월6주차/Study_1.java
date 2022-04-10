package study_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Study_1 {

	public static void main(String[] args) throws IOException {
		// n명의 학생이 A,B,C,D,E 후보중 한명을 선택한다. 
		// 가장 많은 표를 받은 학생을 출력한다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[] c = new char[n];
		for(int i=0; i<n; i++) {
			c[i]=(char) (br.read());
		}
		br.close();

		HashMap<Character, Integer> map = new HashMap<>();
		char answer=' ';
		int max=Integer.MIN_VALUE;
		for(char x : c) {
			// HashMap을 통해 각 후보가 몇 표를 받았는지를 더해준다.
			map.put(x, map.getOrDefault(x, 0)+1);
			// 최대값보다 더 큰 값이 존재한다면 그 값이 최대값이 되고, 
			// 최대값을 가진 그 학생이 출력되도록 answer변수의 값을 넣어준다.
			if(max<map.get(x)) {
				max=map.get(x);
				answer = x;
			}
		}
		
		System.out.println(answer);
	}

}
