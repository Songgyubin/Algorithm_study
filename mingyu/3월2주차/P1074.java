import java.util.Scanner;

public class P1074 {
    static int z=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        int size = (int) Math.pow(2, N);
        System.out.println(Z(size, r, c));
    }

    private static int Z(int size, int r, int c){
        if(size == 2){
            if(r%size == 0 && c%size == 0){
                return z;
            } else if(r%size == 0 && c%size == 1){
                return z+1;
            } else if(r%size == 1 && c%size == 0){
                return z+2;
            } else {
                return z+3;
            }
        } else{
            if((r%size < (size/2)) && (c%size < (size/2))){
                z+=((size/2)*(size/2)) * 0;
                return Z(size/2, r, c);
            } else if((r%size < (size/2)) && (c%size > (size/2))){
                z+=((size/2)*(size/2)) * 1;
                return Z(size/2, r, c);
            } else if((r%size >(size/2)) && (c%size <(size/2))){
                z+=((size/2)*(size/2)) * 2;
                return Z(size/2, r, c);
            } else {
                z+=((size/2)*(size/2)) * 3;
                return Z(size/2, r, c);
            }
        }
    }
}
