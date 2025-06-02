// https://codeforces.com/contest/807/problem/A

import java.util.*;
public class isItRated {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] data = new int[n][2];
        boolean isRated = false;

        for(int i=0; i<n; i++){
            data[i][0] = sc.nextInt();
            data[i][1] = sc.nextInt();
            if(data[i][0] != data[i][1]){
                isRated = true;
            }
        }

        if(isRated){
            System.out.println("rated");
            return;
        }

        for (int i = 0; i < n-1; i++) {
            if(data[i][0] < data[i+1][0]){
                System.out.println("unrated");
                return;
            }
        }
        System.out.println("maybe");

    }
}