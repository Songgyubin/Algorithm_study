package study_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Study_2 {

	public static void main(String[] args) throws IOException {
		// 두 문자열의 알파벳 나열 순서가 다르지만 그 구성이 일치하면 "YES"출력, 아니면 "NO"를 출력.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine();
		br.close();
		
		HashMap<Character, Integer> map = new HashMap<>();
		// 1번째 문자열의 알파벳의 갯수를 세면서 하나씩 더해준다.
		for(char x : str1.toCharArray()) {
			map.put(x, map.getOrDefault(x, 0)+1);
		}
		
		String answer = "YES";
		// 2번째 문자열의 알파벳의 갯수를 세면서 하나씩 빼준다.
		// 만약 2번째 문자열의 알파벳이 1번째 문자열의 포함되지 않는 문자이거나,
		// 개수가 0보다 작아질경우 두 문자열의 구성은 다르기 때문에 NO를 출력한다.
		for(char x : str2.toCharArray()) {
			if(!map.containsKey(x) || map.get(x)==0) {
				answer="NO";
				break;
			}
			map.put(x, map.get(x)-1);
		}
		
		System.out.println(answer);
	}

}
