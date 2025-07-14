// https://codeforces.com/problemset/problem/1849/B

import java.util.*;
public class monsters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int k = sc.nextInt();

            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                long a = sc.nextLong();
                int rem = (int) ((a%k==0) ? k : (a%k));
                arr[i][0] = rem;
                arr[i][1] = i+1;
            }
            Arrays.sort(arr, (x,y) -> {
                if(y[0]!=x[0]) return y[0]-x[0];
                return x[1]-y[1];
            });
            for(int i=0;i<n; i++){
                System.out.print(arr[i][1] + " ");
            }

        }
    }
}
