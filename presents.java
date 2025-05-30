// https://codeforces.com/contest/136/problem/A

import java.util.*;
public class presents {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int index = arr[i] - 1;
            res[index] = i+1;

        }
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}