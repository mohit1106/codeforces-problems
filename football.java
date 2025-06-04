// https://codeforces.com/contest/43/problem/A

import java.util.*;
public class football {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String[] arr = new String[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.next();
        }

        String char1 = arr[0];
        String char2 = "";
        for(int i=1; i<n; i++){
            if(!arr[i].equals(char1)){
                char2 = arr[i];
                break;
            }
        }
         
        int n1 = 0, n2 = 0;
        for (int i = 0; i < n; i++) {
            if(arr[i].equals(char1)) n1++;
            else n2++;
        }

        System.out.println(n1>n2 ? char1 : char2);

    }
}