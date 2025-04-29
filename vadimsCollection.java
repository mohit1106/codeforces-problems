// https://codeforces.com/contest/2098/problem/A

import java.util.*;
public class vadimsCollection {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0){
            String s = sc.next();
            int[] count = new int[10];

            for(char c : s.toCharArray()){
                count[c-'0']++; // The index represents the digit, and the value at each index is the count of that digit
            }

            StringBuilder result = new StringBuilder();
            for (int i = 0; i < 10; i++) {
                int mindigit = 9 - i;
                for(int j = mindigit; j<=9; j++){
                    if(count[j] > 0){
                        result.append(j);
                        count[j]--;
                        break;
                    }
                }
            }
            System.out.println(result.toString());
        }
    }
}