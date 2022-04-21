package gyungchan.study;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B_11866 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		scan.close();
		
		Queue<Integer> Q = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=n; i++) {
			Q.offer(i);
		}
		
		sb.append("<");
		int cnt=1;
		while(Q.size()!=1) {
			if(cnt!=k) {
				Q.offer(Q.poll());
				cnt++;
			}
			else {
				sb.append(Q.poll()).append(", ");
				cnt=1;
			}
		}
		sb.append(Q.peek()).append(">");
		System.out.println(sb);
	}

}
