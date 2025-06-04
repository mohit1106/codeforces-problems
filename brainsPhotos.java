// https://codeforces.com/contest/707/problem/A

import java.util.*;
public class brainsPhotos {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();

        char[][] arr = new char[rows][cols];
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                arr[i][j] = sc.next().charAt(0);
            }
        }

        boolean colorless = true;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (arr[i][j] == 'C' || arr[i][j] == 'M' || arr[i][j] == 'Y') {
                    colorless = false;
                }
            }
        }

        System.out.println(colorless ? "#Black&White" : "#Color");
    }
}