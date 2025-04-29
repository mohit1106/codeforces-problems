// https://codeforces.com/contest/686/problem/A

import java.util.*;
public class freeIceCream {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();

        int distressedKids = 0;
        char[] sign = new char[n];
        int[] people = new int[n];

        for(int i=0; i<n; i++){
            sign[i] = sc.next().charAt(0);
            people[i] = sc.nextInt();
        }
        
        for(int i=0; i<n; i++){
            if(sign[i] == '+'){
                x = x + people[i];
            } else{
                if(x>=people[i]){
                    x = x - people[i];
                }else{
                    distressedKids++;
                }
            }
        }
        System.out.println(x + " " + distressedKids);
    }
}