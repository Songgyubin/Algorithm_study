import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_10872 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        System.out.println(factorial(N));
    }

    public static int factorial(int x) {
        if (x <= 1) {
            return 1;
        } else
            return x * factorial(x - 1);

    }
}
