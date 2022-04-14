package gyungchan.study;

import java.util.Scanner;
import java.util.Stack;

public class B_10773 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int k = scan.nextInt();
		int[] arr = new int[k];
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<k; i++) {
			arr[i]=scan.nextInt();
			if(arr[i]!=0) stack.push(arr[i]);
			else stack.pop();
		}
		scan.close();
		
		int answer=0;
		for(int x : stack) {
			answer+=x;
		}
		System.out.println(answer);
	}

}
