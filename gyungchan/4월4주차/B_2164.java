package gyungchan.study;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B_2164 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		Queue<Integer> Q = new LinkedList<>();
		for(int i=1; i<=N; i++) {
			Q.offer(i);
		}
		int cnt=1;
		while(Q.size()!=1) {
			if(cnt%2==1) {
				Q.poll();
			}
			else {
				Q.offer(Q.poll());
			}
			cnt++;
		}
		scan.close();
		System.out.println(Q.peek());
	}

}
