package gyungchan.study;

import java.util.Scanner;
import java.util.StringTokenizer;

public class B_1152 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		scan.close();
		StringTokenizer st = new StringTokenizer(str, " ");
		System.out.println(st.countTokens());
	}

}
