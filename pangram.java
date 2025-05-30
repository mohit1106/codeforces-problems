// https://codeforces.com/contest/520/problem/A

import java.util.*;
public class pangram {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String str = sc.next().toLowerCase(Locale.ENGLISH);
        boolean well = true;
        for(char c = 'a'; c<='z'; c++){
            if(str.contains(String.valueOf(c))) continue;
            else {
                well = false;
                break;
            }
        }
        System.out.println(well ? "YES" : "NO");
    }
}