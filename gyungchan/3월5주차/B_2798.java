package gyungchan.study;

import java.util.Scanner;

public class B_2798 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int[] arr = new int[a];
		for(int i=0; i<a; i++) {
			arr[i] = scan.nextInt();
		}
		scan.close();
		int sum = 0;
		for(int i=0; i<a; i++) {
			for(int j=i+1; j<a; j++) {
				for(int k=j+1; k<a; k++) {
					if((arr[i]+arr[j]+arr[k])<=b) {
						sum = Math.max(sum, arr[i]+arr[j]+arr[k]);
					}
				}
			}
		}
		System.out.println(sum);
	}

}
