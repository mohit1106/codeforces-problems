// https://codeforces.com/contest/567/problem/A

import java.util.*;

public class linelandMail {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(Math.abs(arr[0]-arr[1]) + " " + Math.abs(arr[0]-arr[n-1]));
        for (int i = 1; i < n-1; i++) {
            int min = Math.min(Math.abs(arr[i]-arr[i-1]), Math.abs(arr[i]-arr[i+1]));
            int max = Math.max(Math.abs(arr[i]-arr[0]), Math.abs(arr[i]-arr[n-1]));
            System.out.println(min + " " + max);
        }
        System.out.println(Math.abs(arr[n-1]-arr[n-2]) + " " + Math.abs(arr[n-1]-arr[0]));

    }
}