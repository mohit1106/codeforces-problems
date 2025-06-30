// https://codeforces.com/problemset/problem/1788/A

import java.util.*; 
public class oneAndTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();  
 
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] prefixTwos = new int[n + 1];
            
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                prefixTwos[i + 1] = prefixTwos[i] + (a[i] == 2 ? 1 : 0);
            }
 
            boolean found = false;
            for (int k = 1; k < n; k++) {
                int leftTwos = prefixTwos[k];    
                int rightTwos = prefixTwos[n] - prefixTwos[k];
 
                if (leftTwos == rightTwos) {
                    System.out.println(k);
                    found = true;
                    break;
                }
            }
 
            if (!found) {
                System.out.println(-1);
            }
        }
 
        sc.close();
    }
}