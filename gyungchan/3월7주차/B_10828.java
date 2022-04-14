package gyungchan.study;

import java.util.Scanner;
import java.util.Stack;

public class B_10828 {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		scan.nextLine();
		String[] str = new String[a];
		for(int i=0; i<a; i++) {
			str[i]=scan.nextLine();
			if(str[i].equals("pop")) {
				if(!stack.isEmpty()) sb.append(stack.pop()).append("\n");
				else sb.append(-1).append("\n");
			}
			else if(str[i].equals("size")) {
				sb.append(stack.size()).append("\n");
			}
			else if(str[i].equals("empty")) {
				if(!stack.isEmpty()) sb.append(0).append("\n");
				else sb.append(1).append("\n");
			}
			else if(str[i].equals("top")) {
				if(!stack.isEmpty()) sb.append(stack.peek()).append("\n");
				else sb.append(-1).append("\n");
			}
			else {
				String[] st = str[i].split(" ");
				int x = Integer.parseInt(st[1]);
				stack.push(x);
			}
		}
		scan.close();
			
		System.out.println(sb);
	}
	
}
