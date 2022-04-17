package gyungchan.study;

import java.util.Scanner;
import java.util.Stack;

public class B_1874 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int max=0;
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			int a = scan.nextInt();
			if(a > max) {
				for(int j=max+1; j<=a; j++) {
					stack.push(j);
					sb.append("+").append("\n");
				}
				max=a;
			}
			else if(stack.peek()!=a) {
				System.out.println("NO");
				scan.close();
				return;
			}
			
			stack.pop();
			sb.append("-").append("\n");
		}
		scan.close();
		System.out.println(sb);
	}

}
