import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
//import java.util.Scanner;

public class B_2309 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Scanner sc = new Scanner(System.in);
        int[] arr = new int[9];

        int sum = 0;
        int nota = 0;
        int notb = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            // arr[i] = sc.nextInt();
            sum += arr[i];

        }
        Arrays.sort(arr);

        for (int a = 0; a < arr.length - 1; a++) {
            for (int b = a + 1; b < arr.length; b++) {
                if (sum - arr[a] - arr[b] == 100) {
                    nota = a;
                    notb = b;
                    break;
                }
            }
        }
        for (int j = 0; j < arr.length; j++) {
            if (j == nota || j == notb)
                continue;
            System.out.println(arr[j]);
        }
        br.close();
    }
}
