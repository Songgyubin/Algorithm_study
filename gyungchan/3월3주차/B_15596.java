package gyungchan.study;

import java.util.Scanner;

public class B_15596 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int[] arr = new int[a];
		
		System.out.println(sum(arr));
	}

	private static long sum(int[] a) {
		long result = 0;
		for(int i=0; i<a.length; i++) {
			result+=i;
		}
		return result;
	}

}
