// https://codeforces.com/problemset/problem/1766/A

import java.util.*;
public class extremelyRound {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n  = sc.nextInt();
            int len = String.valueOf(n).length();

            // if(n<=9) {
            //     System.out.println(n);
            //     return;
            // }

            int count = 0;
            count += (len-1)*9;
            int base = (int) Math.pow(10, len-1);
            for(int i=1;i<=9;i++){
                if (base*i <=n) count++;
            }
            System.out.println(count);
        }
    }
}
