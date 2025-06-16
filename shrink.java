// https://codeforces.com/contest/2117/problem/B

import java.util.*;
public class shrink {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();

            int[] arr = new int[n];
            int idx = 0;
            for(int i=1; i<=n; i++){
                if(i%2 != 0) arr[idx++] = i;
            }

            int startEven = n%2 == 0 ? n : n-1;
            for(int i=startEven; i>=2; i--){
                if(i%2 == 0) arr[idx++] = i;
            }

            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}

