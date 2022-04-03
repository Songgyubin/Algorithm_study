import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2609 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int d = gcd(a, b); // 최대 공약수 구하기

        System.out.println(d);
        System.out.println(a * b / d); // 최대공배수는 a*b에서 최대공약수로 나눠준 값이다.

    }

    public static int gcd(int a, int b) { // 유클리드 호제법, r은 a%b 값인데 a,b와 b,r은 공약수를 가진다.
        // 재귀 방식
        if (b == 0) { //재귀 탈출 조건 명시
            return a;
        }
        return gcd(b, a % b); 
    }
}
