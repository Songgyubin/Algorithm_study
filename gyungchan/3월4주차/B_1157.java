package gyungchan.study;

import java.util.Scanner;

public class B_1157 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		scan.close();
		
		// 입력받은 문자열을 모두 대문자로 변경 
		str = str.toUpperCase();
		
		// 문자를 비교하기 위해 문자 배열 생성 
		char[] c = str.toCharArray();
		
		// 문자의 갯수를 저장하기 위해 정수 배열 생성 
		int[] arr = new int[str.length()];
		
		int count=0;
		int n=0;
		int max = Integer.MIN_VALUE;
		
		// 문자열이 한글자일때  
		if(str.length()==1) {
			System.out.println(str.charAt(0)); 
		}
		
		else{
			for(int i=0; i<str.length(); i++) {
				// 문자 갯수를 세기 위한 반복
				for(int j=i+1; j<str.length(); j++) {
					if(c[i]==c[j]) {
						arr[i]++;
					}
					if(max<arr[i]) max=arr[i];
				}
			}
			for(int i=0; i<str.length(); i++) {
				if(max==arr[i]) {
					count++;
					n=i;
				}
			}
			if(count>=2) {
				System.out.println("?");
			}else System.out.println(c[n]);
			
		}
		
	}

}
