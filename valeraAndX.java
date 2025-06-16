// https://codeforces.com/contest/404/problem/A

import java.util.*;
public class valeraAndX {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); 

        char[][] arr = new char[n][n];
        for(int i=0; i<n; i++){
            String line = sc.nextLine();
            arr[i] = line.toCharArray();
        }
        boolean form = true;
        if(arr[0][0] == arr[0][1]) {
            System.out.println("NO");
            return;
        }
        for (int i = 0; i < n && form; i++) {
            for (int j = 0; j < n; j++) {
                if((i==j) || ((i+j)==(n-1))){
                    if(arr[i][j] != arr[0][0]) {
                        form = false;
                        break;
                    }
                } else{
                    if(arr[i][j] != arr[0][1]) {
                        form = false;
                        break;
                    }
                }
            }
        }
        System.out.println(form ? "YES" : "NO");
    }
}