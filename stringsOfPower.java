// https://codeforces.com/contest/318/problem/B

import java.util.Scanner;

public class stringsOfPower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        
        long countHeavy = 0;
        long result = 0;
        int n = s.length();
        
        for (int i = 0; i <= n - 5; i++) {
            String sub = s.substring(i, i + 5);
            if (sub.equals("heavy")) {
                countHeavy++;
            } else if (sub.equals("metal")) {
                result += countHeavy;
            }
        }
        
        System.out.println(result);
    }
}
