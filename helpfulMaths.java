// https://codeforces.com/contest/339/problem/A

import java.util.*;
public class helpfulMaths {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        int n = str.length();
        int count1 = 0, count2 = 0, count3 = 0;
        for(int i=0; i<n; i++){
            if(str.charAt(i) == '1') count1++;
            else if(str.charAt(i) == '2') count2++;
            else if(str.charAt(i) == '3') count3++;
            else continue;
        }

        StringBuilder result = new StringBuilder();
        for(int i=0; i<count1; i++){
            result.append("1+");
        }
        for(int i=0; i<count2; i++){
            result.append("2+");
        }
        for(int i=0; i<count3; i++){
            result.append("3+");
        }
        if(result.charAt(result.length()-1) == '+') result.deleteCharAt(result.length()-1);
        System.out.println(result.toString());
    
    }
}