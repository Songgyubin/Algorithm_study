import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B_2501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()); // 입력 값 공백 생각하기

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int result = 0;
        int plus = 0;

        for (int i = 1; i <= N; i++) {
            if (N % i == 0) {
                plus++;
            }

            if (plus == K) {
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}
