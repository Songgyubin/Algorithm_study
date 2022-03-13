import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10951 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            try {
                st = new StringTokenizer(br.readLine()); // 띄어쓰기로 끊어서 토큰화

                int a = Integer.parseInt(st.nextToken()); // a
                int b = Integer.parseInt(st.nextToken()); // b
                sb.append(a + b).append("\n"); // StringBuilder에 a+b로 append
            } catch (Exception e) {

                break;
            }
        }
        System.out.print(sb);

    }
}
