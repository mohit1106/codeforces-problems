// https://codeforces.com/contest/742/problem/A

import java.util.*;
public class arpasHardExam {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int base = 8;
        int rem;
        if(n == 0){
            System.out.println(1);
            return;
        }
        if(n<10){
            rem = n%4;
            if(rem == 0) rem = 4;
        } else{
            String powerString = String.valueOf(n);
            int len = powerString.length();
            String lasttwodigit = powerString.substring(len-2, len);
            int lasttwo = Integer.parseInt(lasttwodigit);
            rem = lasttwo % 4;
            if(rem == 0) rem = 4;
        }
        int res = 1;
        for(int i=0; i<rem; i++){
            res = res*base;
        }
        System.out.println(res%10);

    }
}