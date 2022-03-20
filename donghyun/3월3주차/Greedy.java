import java.util.Scanner;

//1이 될 때 까지
public class Greedy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int result = 0;

        while (true) {
            int target = (n / k) * k;
            result += (n - target);
            n = target;
            if (n < k)
                break;
            result += 1;
            n /= k;
        }
        result += (n - 1);
        System.out.println(result);
    }
}
