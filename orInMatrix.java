// https://codeforces.com/contest/486/problem/B

import java.util.*;
public class orInMatrix {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];

        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) arr[i][j] = sc.nextInt();
        }
        for(int i=0; i<n; i++) Arrays.fill(res[i], 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    for (int k = 0; k < m; k++) res[i][k] = 0;
                    for (int k = 0; k < n; k++) res[k][j] = 0;
                }
            }
        }
        boolean flag = true;
        for (int i = 0; i < n && flag; i++) {
            for (int j = 0; j < m && flag; j++) {
                int temp = 0;
                for (int k = 0; k < m; k++) temp = temp | res[i][k];
                for (int k = 0; k < n; k++) temp = temp | res[k][j];
                if(temp != arr[i][j]){
                    flag = false;
                    break;
                }
            }
        }
        if(!flag) System.out.println("NO");
        else {
            System.out.println("YES");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(res[i][j] + " ");
                }
                System.out.println();
            }
        }

    }
}