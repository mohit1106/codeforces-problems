// https://codeforces.com/contest/766/problem/B

import java.util.*;
public class mahmoudAndTriangle {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        boolean found = false;
        for (int i = 0; i < n-2; i++) {
            if(arr[i] + arr[i+1] > arr[i+2]){
                found = true;
                break;
            }
            
        }
        if (found) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}