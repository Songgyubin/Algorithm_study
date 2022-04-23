package gyungchan.study;

import java.util.Scanner;

public class B_10872 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();
		System.out.println(f(n));
	}
	static int f(int n) {
		if(n<=1) return 1;
		return n*f(n-1);
	}
}
