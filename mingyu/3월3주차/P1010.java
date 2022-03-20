import java.util.Scanner;

public class P1010 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        int arr[][] = new int[30][30];

        for(int i=0;i<30;i++){
            arr[i][i] = 1;
            arr[i][0] = 1;
        }
        for (int i = 2; i < 30; i++) {
            for (int j = 1; j < 30; j++) {
                arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
            }
        }
        T = sc.nextInt();
        for(int i = 0; i < T; i++) {

            int N = sc.nextInt();
            int M = sc.nextInt();
            System.out.println(arr[M][N]);
        }
    }
}