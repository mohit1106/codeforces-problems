// https://codeforces.com/contest/732/problem/A

import java.util.*;
public class buyAShovel {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int r = sc.nextInt();

        for(int i=1; i<=10; i++){
            int price = i*k;
            if((price%10 == 0) || (price%10 == r)){
                System.out.println(i);
                break;
            }
        }
    }
}