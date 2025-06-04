// https://codeforces.com/contest/584/problem/A

import java.util.*;
public class olesyaAndRodion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int digit = sc.nextInt();
        int divisor = sc.nextInt();

        if(digit==1 && divisor==10){
            System.out.println("-1");
            return;
        }

        if(divisor==10){
            System.out.print("1");
            for (int i = 1; i < digit; i++) {
                System.out.print("0");
            }
            System.out.println();
            return;
        }

        StringBuilder num = new StringBuilder();
        num.append(divisor);
        while(num.length()<digit){
            num.append("0");
        }
        System.out.println(num.toString());
    }
}