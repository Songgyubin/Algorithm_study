import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//public class P2606 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n,m;
//        n = sc.nextInt();
//        m = sc.nextInt();
//        int arr[][] = new int [n+1][n+1];
//
//        for(int i=0;i<m;i++){
//            int n1, n2;
//            n1 = sc.nextInt();
//            n2 = sc.nextInt();
//            arr[n1][n2] = 1;
//        }
//
//        Queue<Integer> queue = new LinkedList<>();
//
//        for(int i=1;i<=n;i++){
//            if(arr[1][i] == 1){
//                queue.offer(i);
//            }
//        }
//        int count = 0;
//        while(!queue.isEmpty()){
//            int k = queue.poll();
//            for(int i=1;i<=n;i++){
//                if(arr[k][i] == 1){
//                    queue.offer(i);
//                    count++;
//                }
//            }
//        }
//        System.out.println(count);
//    }
//}

public class P2606 {
    static int cnt = 0;
    static void dfs(int[][] a, boolean[] check, int v) {
        if(check[v]==true) return;

        check[v] = true;
        cnt++;

        for(int i=0;i<a[v].length;i++) {
            if(a[v][i]==1 && !check[i])
                dfs(a,check,i);
        }
    }

    public static void main(String[] args)  {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int e = in.nextInt();

        int a[][] = new int[n+1][n+1];
        boolean check[] = new boolean[n+1];

        for(int i=0;i<e;i++) {
            int v1 = in.nextInt();
            int v2 = in.nextInt();

            a[v1][v2] = 1;
            a[v2][v1] = 1;
        }

        dfs(a,check,1);

        System.out.println(cnt-1);

    }
}