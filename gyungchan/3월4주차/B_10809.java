package gyungchan.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_10809 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		br.close();
		int[] arr= new int[26];
		
		for(int i=0; i<26; i++) {
			arr[i]=-1;
		}
		for(int i=0; i<str.length(); i++) {
			int j=97;
			while(str.charAt(i)!=(char)j) {
				j++;
			}
			if(str.charAt(i)==(char)j){
				arr[j-97]=str.indexOf((char)j);
			}
		}
		for(int i=0; i<26; i++) {
			System.out.print(arr[i]+" ");
		}
	}

}
