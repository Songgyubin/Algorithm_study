package gyungchan.study;

import java.util.Scanner;
import java.util.Stack;

public class B_9012 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		String[] str = new String[n];
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<n; i++) {
			String answer = "YES";
			str[i]=scan.next();
			for(char x : str[i].toCharArray()) {
				if(x=='(') stack.push(x);
				else {
					if(stack.isEmpty()) {
						answer = "NO";
						break;
					}
					stack.pop();
				}
			}
			if(!stack.isEmpty()) answer="NO";
			stack.clear();
			sb.append(answer).append("\n");
		}
		scan.close();
		System.out.println(sb);
	}

}
