// https://codeforces.com/problemset/problem/1883/B

import java.util.*;
public class chemistry {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            String str = sc.next();
            int[] count = new int[26];
            for(char c : str.toCharArray()){
                count[c-'a']++;
            }
            int oddcount=0;
            for(int i : count){
                if(i%2 !=0) oddcount++;
            }

            int remaining = n-k;
            
            if(k<=n && oddcount<=remaining%2+k) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}