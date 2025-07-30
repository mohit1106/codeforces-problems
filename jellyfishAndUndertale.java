// https://codeforces.com/problemset/problem/1875/A

import java.util.*;
public class jellyfishAndUndertale {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            long a = sc.nextLong();
            long b = sc.nextLong();
            int n = sc.nextInt();

            long[] arr = new long[n];
            for(int i=0;i<n;i++){
                arr[i] = sc.nextLong();
            }

            long res = b;
            for (int i = 0; i < n; i++) {
                long x = arr[i];
                res += Math.min(x, a - 1);
            }
            System.out.println(res);
        }
    }
}
