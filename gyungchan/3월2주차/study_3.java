package gyungchan.study;

import java.util.Scanner;

public class study_3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int a = scan.nextInt();
		double[] arr = new double[a];
		double sum = 0;
		double max = 0;
		
		for(int i=0; i<arr.length; i++) {
			arr[i]=scan.nextDouble();
			if(max<arr[i]) max=arr[i];
		}
		
		for(int i=0; i<arr.length; i++) {
			arr[i]=arr[i]/max*100;
			sum+=arr[i];
		}
		System.out.println(sum/a);
	}

}
