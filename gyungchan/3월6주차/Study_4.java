package study_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Study_4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String t = br.readLine();
		br.close();
		
		HashMap<Character, Integer> map1 = new HashMap<>();
		HashMap<Character, Integer> map2 = new HashMap<>();
		for(char x : t.toCharArray()) {
			map2.put(x, map2.getOrDefault(x, 0)+1);
		}
		
		int count=0;
		int lt=0;
		for(int i=0; i<t.length()-1; i++) {
			map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i), 0)+1);
		}
		for(int rt=t.length()-1; rt<s.length(); rt++) {
			map1.put(s.charAt(rt), map1.getOrDefault(s.charAt(rt), 0)+1);
			if(map1.equals(map2)) count++;
			map1.put(s.charAt(lt), map1.get(s.charAt(lt))-1);
			if(map1.get(s.charAt(lt))==0) map1.remove(s.charAt(lt));
			lt++;
		}
		System.out.println(count);
	}

}
