// https://codeforces.com/problemset/problem/1834/A

import java.util.*;
public class unitArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int[] arr = new int[n];
            int count1 = 0, countm1 = 0;
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
                if(arr[i] == 1) count1++;
                else countm1++;
            }

            int ans = 0;
            while (count1 - countm1 < 0) {
                countm1--;
                count1++;
                ans++;
            }
            if (countm1 % 2 != 0) {
                ans++;
            }
            System.out.println(ans);
        }
    }
}