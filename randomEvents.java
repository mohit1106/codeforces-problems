// https://codeforces.com/problemset/problem/1461/C

import java.util.*;
public class randomEvents {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t =sc.nextInt();

        while (t--> 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int minlen = 0;
            for (int i = n-1; i >=0; i--) {
                if (arr[i] != i + 1) {
                    minlen = i+1;
                    break;
                }
            }

            if (minlen == 0) {
                System.out.printf("%.6f\n", 1.0);
                for (int i = 0; i < m; i++) {
                    sc.nextInt();
                    sc.nextDouble();
                }
                continue;
            }

            double probNotSorted = 1.0;
            for (int i = 0; i < m; i++) {
                int   r = sc.nextInt();
                double p = sc.nextDouble();
                if (r >= minlen) {
                    probNotSorted *= (1.0 - p);
                }
            }

            double ans = 1.0 - probNotSorted;
            System.out.printf("%.6f\n", ans);
        }
    }
}
