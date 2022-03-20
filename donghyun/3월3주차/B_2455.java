import java.util.Scanner;

public class B_2455 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int max = -1, total = 0;

        for (int i = 0; i < 4; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            total += b - a;
            if (max < total) {
                max = total;
            }
        }
        System.out.println(max);
    }
}
