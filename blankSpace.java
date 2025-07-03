// https://codeforces.com/problemset/problem/1829/B

import java.util.*;
public class blankSpace {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();

            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }

            int max = 0;
            int count = 0;
            if(n==1 && arr[0]==0){
                max = 1;
            }
            for(int i=0; i<n; i++){
                if(arr[i] == 0){
                    count++;
                }else{
                    max = Math.max(max, count);
                    count = 0;
                }
            }
            max = Math.max(max, count);
            System.out.println(max);
        }
    }
}