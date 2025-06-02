// https://codeforces.com/contest/451/problem/B

import java.util.*;

public class sortTheArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int l = 0, r = n - 1;

        // Find the first index where the array is not increasing
        while(l < n - 1 && arr[l] <= arr[l + 1]) {
            l++;
        }

        // If the entire array is already sorted
        if(l == n - 1) {
            System.out.println("yes");
            System.out.println("1 1");
            return;
        }

        // Find the last index where the array is not increasing
        while(r > 0 && arr[r] >= arr[r - 1]) {
            r--;
        }

        // Reverse the subarray from l to r
        reverse(arr, l, r);

        // Check if array is sorted after reversing
        if(isSorted(arr)) {
            System.out.println("yes");
            System.out.println((l + 1) + " " + (r + 1));  // 1-based index
        } else {
            System.out.println("no");
        }
    }

    static void reverse(int[] arr, int l, int r) {
        while(l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }

    static boolean isSorted(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            if(arr[i] > arr[i + 1]) return false;
        }
        return true;
    }
}
