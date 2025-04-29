// https://codeforces.com/contest/112/problem/A

import java.util.Scanner;

public class petyaAndStrings {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();

        String ss1 = s1.toLowerCase();
        String ss2 = s2.toLowerCase();

        int res = ss1.compareTo(ss2);
        if(res<0) System.out.println(-1);
        else if(res>0) System.out.println(1);
        else System.out.println(0);
    }
}