// https://codeforces.com/contest/486/problem/A

import java.util.*;
public class calculatingFunction {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long sum = 0;

        long evens = n/2, odds = 0;
        if(n%2 == 0) odds = n/2;
        else odds = (n+1)/2;

        long evensums = evens * (evens+1);
        long oddsums = odds * odds;

        System.out.println(evensums - oddsums);
    }
}