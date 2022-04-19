package gyungchan.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class B_18258 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		LinkedList<Integer> Q = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			if(str.equals("front")) {
				if(Q.isEmpty()) sb.append(-1).append("\n");
				else sb.append(Q.peek()).append("\n");
			}
			else if(str.equals("back")) {
				if(Q.isEmpty()) sb.append(-1).append("\n");
				else sb.append(Q.peekLast()).append("\n");
			}
			else if(str.equals("empty")) {
				if(Q.isEmpty()) sb.append(1).append("\n");
				else sb.append(0).append("\n");
			}
			else if(str.equals("size")) {
				sb.append(Q.size()).append("\n");
			}
			else if(str.equals("pop")) {
				if(Q.isEmpty()) sb.append(-1).append("\n");
				else sb.append(Q.poll()).append("\n");
			}
			else {
				String[] s = str.split(" ");
				Q.offer(Integer.parseInt(s[1]));
			}
		}
		br.close();
		System.out.println(sb);
	}

}
