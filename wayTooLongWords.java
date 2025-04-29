// https://codeforces.com/contest/71/problem/A

import java.util.*;
public class wayTooLongWords {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int  n= sc.nextInt();

        for(int i=0; i<n; i++){
            String word = sc.next();
            
            StringBuilder result = new StringBuilder();
            if (word.length() > 10) {
                result.append(word.charAt(0));
                result.append(word.length() - 2);
                result.append(word.charAt(word.length()-1));
            } else{
                result.append(word);
            }
            System.out.println(result.toString());
        }
    }
}