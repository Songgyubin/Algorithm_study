package gyungchan.study;

import java.util.Scanner;

public class B_2941 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		scan.close();
		int count=0;
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)=='=') {
				if(str.charAt(i-1)=='z' && str.charAt(i-2)=='d') {
					count--;
				}
				else if(str.charAt(i-1)=='c' || str.charAt(i-1)=='s' || str.charAt(i-1)=='z') {
					count+=0;
				}
				else count++;
			}
			else if(str.charAt(i)=='-') {
				if(str.charAt(i-1)=='c' || str.charAt(i-1)=='d') {
					count+=0;
				}else count++;
			}
			else if(str.charAt(i)=='j') {
				if(str.charAt(i-1)=='l' || str.charAt(i-1)=='n') {
					count+=0;
				}else count++;
			}
			else count++;
		}
		System.out.println(count);
	}

}
