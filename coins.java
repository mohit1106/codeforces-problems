// https://codeforces.com/problemset/problem/1814/A

import java.util.*;
public class coins {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-- > 0){
            long n = sc.nextLong();
            long k = sc.nextLong();
            
            boolean valid;
            if(n%2 == 0){
                valid = true;
            } else{
                if(n>=k && k%2==1) valid = true;
                else valid = false;
            }
            System.out.println(valid ? "YES" : "NO");
        }
    }
}