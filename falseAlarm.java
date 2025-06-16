// https://codeforces.com/contest/2117/problem/A

import java.util.*;
public class falseAlarm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int x = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }
            int left = 0, right = 0;
            for(int i=0; i<n; i++){
                if(arr[i] == 1) {
                    left = i;
                    break;
                }
            }
            for(int i=n-1; i>=0; i--){
                if(arr[i] == 1) {
                    right = i;
                    break;
                }
            }
            int so = right-left + 1;
            if (so <=x) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
