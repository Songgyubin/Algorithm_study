package gyungchan.study;

import java.util.Scanner;

public class B_2231 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int val = scan.nextInt();
		scan.close();
		
		int answer = 0;
		for(int i=1; i<val; i++) {
			int sum=i;
			int tmp=i;
			while(tmp!=0) {
				sum+=tmp%10;
				tmp/=10;
			}
			if(sum==val) {
				answer=i;
				break;
			}
		}
		System.out.println(answer);
	}

}
