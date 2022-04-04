package gyungchan.study;

import java.util.Scanner;

public class B_7568 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int val = scan.nextInt();
		int[] weight = new int[val];
		int[] height = new int[val];
		
		for(int i=0; i<val; i++) {
			weight[i]=scan.nextInt();
			height[i]=scan.nextInt();
		}
		scan.close();
		
		for(int i=0; i<val; i++) {
			int count=1;
			for(int j=0; j<val; j++) {
				if(weight[i]<weight[j] && height[i]<height[j]) {
					count++;
				}
			}
			System.out.print(count+" ");
		}
	}

}
