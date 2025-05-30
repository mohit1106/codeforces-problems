// https://codeforces.com/contest/474/problem/A

import java.util.*;
public class keyboard {

    public static void main(String[] args) {
        String keys = "qwertyuiopasdfghjkl;zxcvbnm,./";
        char[] arr = keys.toCharArray();

        Scanner sc = new Scanner(System.in);
        char direction = sc.next().charAt(0);
        String str = sc.next();

        StringBuilder res = new StringBuilder();
        for(char c : str.toCharArray()){
            int idx = keys.indexOf(c);

            if (direction == 'R') {
                res.append(keys.charAt(idx -1));
            } else {
                res.append(keys.charAt(idx +1));
            }
        }
        System.out.println(res);
        
    }
}