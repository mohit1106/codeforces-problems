// https://codeforces.com/problemset/problem/1805/A

import java.util.*;
public class weNeedTheZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int xor = 0;

            int arr[] = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
                xor = xor^arr[i];
            }
            
            if(n%2 == 1){
                System.out.println(xor);
            } else{
                if (xor == 0) {
                    System.out.println(0);
                } else {
                    System.out.println(-1);
                }
            }
        }
    }
}
