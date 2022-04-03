package gyungchan.study;

import java.util.Scanner;

public class B_1316 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int val = scan.nextInt();
		String[] str = new String[val];
		for(int i=0; i<val; i++) {
			str[i] = scan.next();
		}
		scan.close();
		
		int num=0;
		for(int i=0; i<val; i++) {
			int count=0;
			for(int j=0; j<str[i].length()-1; j++) {
				for(int k=j+1; k<str[i].length(); k++) {
					// 연속된 같은 문자가 있을 때는 카운트를 하지 않고 넘어감.
					if(str[i].charAt(j)==str[i].charAt(j+1)) {
						break;
					}
					// 연속되진 않았지만 같은 문자가 있을 경우 카운트를 한다.
					else if(str[i].charAt(j)==str[i].charAt(k)) {
						count++;
					}
				}
			}
			// 카운트가 되지 않았다면 그룹단어이기 떄문에 num 변수 값 증가.
			if(count==0) num++;
		}
		System.out.println(num);
	}

}
