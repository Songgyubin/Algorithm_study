package gyungchan.study;

import java.util.Scanner;

public class study_1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int[] a = new int[3];
		int b = 1;
		
		for(int i=0; i<a.length; i++) {
			a[i] = scan.nextInt();
			b*=a[i];
		}
		
		String str = Integer.toString(b);
		
		for(int i=0; i<10;i++) {
			int count = 0;
			for(int j=0; j<str.length(); j++) {
				if(str.charAt(j)-'0'==i) {
					count++;
				}
			}
			System.out.println(count);
		}
	}

}
