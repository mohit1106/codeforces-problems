// https://codeforces.com/contest/236/problem/A

import java.util.*;
public class boyOrGirl {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        int distinct = 0;
        int n = str.length();

        Set<Character> uniqueChars = new HashSet<>();
        for (Character ch : str.toCharArray()) {
            uniqueChars.add(ch);
        }

        int size = uniqueChars.size();
        if (size%2 == 0) System.out.println("CHAT WITH HER!");
        else System.out.println("IGNORE HIM!");
    }
}