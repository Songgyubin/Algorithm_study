package gyungchan.study;

import java.util.Scanner;

public class study_5 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int a = scan.nextInt();
		
		int[] arr;
		for(int i=0; i<a;i++) {
			int b=scan.nextInt();
			arr = new int[b];
			double sum = 0;
			for(int j=0; j<b; j++) {
				int val = scan.nextInt();
				arr[j]=val;
				sum+=val;
			}
			double mean = (sum/b);
			double count =0;
			
			for(int j=0; j<b; j++) {
				if(arr[j]>mean) count++;
			}
			
			System.out.printf("%.3f", count/b*100);
		}
	}

}
