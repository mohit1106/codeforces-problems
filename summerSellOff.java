// https://codeforces.com/contest/810/problem/B

import java.util.*;
public class summerSellOff {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int f = sc.nextInt();

        long[] k = new long[n];
        long[] l = new long[n];

        for (int i = 0; i < n; i++) {
            k[i] = sc.nextLong();
            l[i] = sc.nextLong();
        }

        long total = 0;
        long[] bonuses = new long[n];
        for (int i = 0; i < n; i++) {
            long normalsale = Math.min(k[i], l[i]);
            long bonus = Math.min(2 * k[i], l[i]) - normalsale;
            bonuses[i] = bonus;
            total += normalsale;
        }
        
        Arrays.sort(bonuses);
        for(int i=0; i<f; i++){
            total += bonuses[n-i-1];
        }
        System.out.println(total);
    }
}