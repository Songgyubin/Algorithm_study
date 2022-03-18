package gyungchan.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_11720 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int val = Integer.parseInt(br.readLine());
		String str = br.readLine();
		br.close();
		
		int sum=0;
		for(int i=0; i<val; i++) {
			int a = Integer.parseInt(String.valueOf(str.charAt(i)));
			sum+=a;
		}
		System.out.println(sum);
	}

}
