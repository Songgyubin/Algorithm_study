package gyungchan.study;

import java.util.Scanner;

public class study_4 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int a = scan.nextInt();
		String[] str = new String[a];
		
		for(int i=0; i<str.length; i++) {
			str[i]=scan.next();
		}
		
		for(int i=0; i<str.length; i++) {
			int count=0;
			int num=0;
			for(int j=0; j<str[i].length();j++) {
				char[] ch = str[i].toCharArray();
				if(ch[j]=='O') {
					count++;
				}else count=0;
				
				num+=count;
			}
			System.out.println(num);
		}
		
	}

}
