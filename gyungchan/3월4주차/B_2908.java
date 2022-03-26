package gyungchan.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2908 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		br.close();
		int[] arr = new int[st.countTokens()];
		int max=0;
		for(int i=0; i<arr.length; i++) {
			arr[i]= Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
			if(arr[i]>max) max=arr[i];
		}
		System.out.println(max);
	}

}
