package algorithm_6;

import java.util.Scanner;

public class Study_2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) arr[i]=scan.nextInt();
		scan.close();
		
		/*while(true) {
			int count=0;
			for(int i=0; i<n-1; i++) {
				if(arr[i]>arr[i+1]) {
					int tmp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = tmp;
					count++;
				}
			}
			if(count==0) break;
		}*/
		for(int i=0; i<n-1; i++) {
			for(int j=0; j<n-i-1; j++) {
				if(arr[j]>arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
		for(int x : arr) {
			System.out.print(x+" ");
		}
	}

}
