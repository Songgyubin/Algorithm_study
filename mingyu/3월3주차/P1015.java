import java.util.Scanner;

public class P1015 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int A[]= new int[size];
        for(int i=0;i<size;i++){
            A[i] = sc.nextInt();
        }
        for(int i=0;i<size;i++){
            int num = 0;
            for(int j=0;j<size;j++){
                if(A[i] > A[j]){
                    num++;
                } else if(A[i] == A[j]){
                    if(i > j){
                        num++;
                    }
                }
            }
            System.out.print(num + " ");
        }
    }
}
