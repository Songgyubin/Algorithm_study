import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_10818 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int max = -1000001;
        int min = 1000001;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (min == 0) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }

        }
        System.out.println(min + " " + max);
    }
}
