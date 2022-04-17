package gyungchan.study;

import java.util.Scanner;
import java.util.Stack;

public class B_4949 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Stack<Character> stack = new Stack<>();
		String answer = "yes";
		StringBuilder sb = new StringBuilder();
		while(true) {
			String str = scan.nextLine();
			if(str.equals(".")) break;
			for(char x : str.toCharArray()) {
				if(x=='(') stack.push(x);
				else if(x=='[') stack.push(x);
				else if(x==')') {
					if(stack.isEmpty() || stack.peek()!='(') {
						answer="no";
						break;
					}
					stack.pop();
				}
				else if(x==']') {
					if(stack.isEmpty() || stack.peek()!='[') {
						answer="no";
						break;
					}
					stack.pop();
				}
			}
			if(!stack.isEmpty()) answer="no";
			sb.append(answer).append("\n");
			answer="yes";
			stack.clear();
		}
		scan.close();
		System.out.println(sb);
	}

}
