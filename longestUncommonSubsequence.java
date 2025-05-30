// https://codeforces.com/contest/766/problem/A

import java.util.*;
public class longestUncommonSubsequence {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str1 = sc.next();
        String str2 = sc.next();

        if(str1.equals(str2)) System.out.println(-1);
        else System.out.println(Math.max(str1.length(), str2.length()));

    }
}