import java.util.Scanner;

public class B_2460 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int max = -1, count = 0;

        for (int i = 1; i <= 10; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            count += b - a;
            if (max < count) {
                max = count;

            }
        }
        System.out.println(max);
    }
}
