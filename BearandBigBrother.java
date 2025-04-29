// https://codeforces.com/contest/791/problem/A

import java.util.Scanner;

public class BearandBigBrother {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int year = 1;
        while(a<=b){
            a = 3*a;
            b = 2*b;
            if (a > b) {
                break;
            }
            year++;
        }
        System.out.println(year);
    }
}