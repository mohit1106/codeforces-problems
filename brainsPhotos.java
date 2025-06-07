// https://codeforces.com/contest/707/problem/A

import java.util.*;
public class brainsPhotos {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        char[][] arr = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.next().charAt(0);
            }
        }

        boolean isBNW = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] == 'C' || arr[i][j] == 'M' || arr[i][j] == 'Y'){
                    isBNW = false;
                }
            }
        }
        System.out.println(isBNW ? "#Black&White" : "#Color");
    }
}
