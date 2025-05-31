// https://codeforces.com/contest/318/problem/A

import java.util.*;
public class evenOdds {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n= sc.nextLong();
        long k = sc.nextLong();

        long mid = (n+1)/2;
        if(k <= mid){
            System.out.println(2*k - 1);
        } else if(k > mid){
            long x = k-mid;
            System.out.println(2*x);
        }
    }
}