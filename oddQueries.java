//https://codeforces.com/problemset/problem/1807/D

import java.util.*;
public class oddQueries {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt(), q = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
            }

            long[] prefix = new long[n+1];
            for (int i = 0; i < n; i++) {
                prefix[i+1] = prefix[i] + arr[i];
            }

            long totalSum = prefix[n];

            for(int i=0; i<q; i++){

                int l = sc.nextInt();
                int r = sc.nextInt();
                int k = sc.nextInt();
                
                long originalSegmentSum = prefix[r] - prefix[l-1];
                long newSegmentSum = (long) k * (r-l+1);
                long newTotal = totalSum-originalSegmentSum+newSegmentSum;

                if(newTotal%2 != 0) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }
}
