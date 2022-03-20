package gyungchan.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_11654 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char c = (br.readLine()).charAt(0);
		br.close();
		
		System.out.println((int)c);
	}

}
