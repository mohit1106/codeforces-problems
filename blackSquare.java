// https://codeforces.com/contest/431/problem/A

import java.util.*;
public class blackSquare {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int calorie1 = sc.nextInt();
        int calorie2 = sc.nextInt();
        int calorie3 = sc.nextInt();
        int calorie4 = sc.nextInt();

        String str = sc.next();
        int n = str.length();
        int total = 0;
        for(int i=0; i<n; i++){
            if(str.charAt(i) == '1') total += calorie1;
            else if(str.charAt(i) == '2') total += calorie2;
            else if(str.charAt(i) == '3') total += calorie3;
            else if(str.charAt(i) == '4') total += calorie4;
            
        }
        System.out.println(total);
    }
}