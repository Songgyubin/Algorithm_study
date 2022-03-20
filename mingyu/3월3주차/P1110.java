import java.util.Scanner;

public class P1110 {
    static int num = 0;
    static int N = 0;
    static int N2 = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        System.out.println(test(N));
    }
    private static int test(int k){
        int n1, n2;
        if(num == 0){
            n1 = k/10;
            n2 = k%10;
        } else{
            n1 = N2%10;
            n2 = k%10;
        }
        int n = n1 + n2;
        if(n1 == N/10 && n2 == N%10 && num != 0){
            return num;
        } else{
            num++;
            N2 = k;
            return test(n);
        }
    }
}
