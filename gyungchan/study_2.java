package gyungchan.study;

import java.util.Scanner;

public class study_2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] a = new int[10];
		for(int i=0; i<10; i++) {
			a[i] = scan.nextInt();
		}
		
		int[] b = new int[10];
		for(int i=0; i<10; i++) {
			b[i]=a[i]%42;
		}
		
		int count = 0;
		int num = 0;
		for(int i=0;i<10;i++) {
			count = 0;
			for(int j=i+1;j<10;j++) {
				if(b[i]==b[j]) {
					count++;
				}
			}
			if(count==0) num++;
		}
		
		System.out.println(num);

	}


}
