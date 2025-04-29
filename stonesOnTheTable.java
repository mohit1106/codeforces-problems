// https://codeforces.com/contest/266/problem/A

import java.util.*;
public class stonesOnTheTable {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        int count =0;
        int start =0;
        // for(int i=0; i<n; i++){
            
        // }
        while(start < n-1){
            if(str.charAt(start) == str.charAt(start + 1)){
                count++;
            }
            start++;
        }
        System.out.println(count);
    }
}