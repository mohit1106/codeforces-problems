// https://codeforces.com/contest/208/problem/A

import java.util.*;
public class dubstep {

    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     String str = sc.next();
    //     int n = str.length();

    //     StringBuilder res = new StringBuilder();
    //     boolean spaceNeeded = false;

    //     int i=0;
    //     while(i<n){
    //         if(i+2 < n && str.substring(i, i+3).equals("WUB")){
    //             i = i+3;
    //             if(res.length() > 0 && res.charAt(res.length() - 1) != ' '){
    //                 spaceNeeded = true;
    //             }
    //         }
    //         else{
    //             if(spaceNeeded){
    //                 res.append(' ');
    //                 spaceNeeded = false;
    //             }
    //             res.append(str.charAt(i));
    //             i++;
    //         }
    //     }
    //     System.out.println(res.toString());

    // }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = str.length();

        String newstr = str.replaceAll("WUB", " ");
        String trimmed = newstr.trim();
        String res = trimmed.replaceAll("\\s+", " ");
        System.out.println(res);
    }
}