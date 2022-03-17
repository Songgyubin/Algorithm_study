package gyungchan.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1065 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int val = Integer.parseInt(br.readLine());
		br.close();
		
		System.out.println(count(val));
	}

	private static int count(int val) {
		int num=0;
		if(1<=val && val<100) {
			for(int i=1; i<=val; i++) {
				num++;
			}
		}else if((100<=val && val<1000) || val==1000){
			num=99;
			for(int i=100; i<=val; i++) {
				int a = i/100;
				int b = (i-(a*100))/10;
				int c = i%10;
				if((2*b)==(a+c)) num++;
			}
		}
		
		return num;
	}

}
