package gyungchan.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_5622 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		br.close();
		
		int sum = 0;
		for(int i=0; i<str.length(); i++) {
			int count = 0;
			if(str.charAt(i)=='A'||str.charAt(i)=='B'||str.charAt(i)=='C') {
				count=3;
				sum+=count;
			}else if(str.charAt(i)=='D'||str.charAt(i)=='E'||str.charAt(i)=='F') {
				count=4;
				sum+=count;
			}else if(str.charAt(i)=='G'||str.charAt(i)=='H'||str.charAt(i)=='I') {
				count=5;
				sum+=count;
			}else if(str.charAt(i)=='J'||str.charAt(i)=='K'||str.charAt(i)=='L') {
				count=6;
				sum+=count;
			}else if(str.charAt(i)=='M'||str.charAt(i)=='N'||str.charAt(i)=='O') {
				count=7;
				sum+=count;
			}else if(str.charAt(i)=='P'||str.charAt(i)=='Q'||str.charAt(i)=='R' ||str.charAt(i)=='S') {
				count=8;
				sum+=count;
			}else if(str.charAt(i)=='T'||str.charAt(i)=='U'||str.charAt(i)=='V') {
				count=9;
				sum+=count;
			}else {
				count=10;
				sum+=count;
			}
		}
		System.out.println(sum);

	}

}
