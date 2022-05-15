package algorithm_6;

import java.util.Scanner;

public class Study_4 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int s = scan.nextInt();
		int n = scan.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) arr[i]=scan.nextInt();
		scan.close();
		
		int[] cache = new int[s];
		for(int x : arr) {
			int pos=-1;
			for(int i=0; i<s; i++) if(x==cache[i]) pos=i;
			if(pos==-1) {
				for(int i=s-1; i>=1; i--) {
					cache[i]=cache[i-1];
				}
				cache[0]=x;
			}
			else {
				for(int i=pos; i>=1; i--) {
					cache[i]=cache[i-1];
				}
				cache[0]=x;
			}
		}
		for(int x : cache) {
			System.out.print(x+" ");
		}
	}

}
