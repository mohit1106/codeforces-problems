// https://codeforces.com/contest/469/problem/A

import java.util.*;
public class iWannaBeTheGuy {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int p = sc.nextInt();
        int[] x = new int[p];
        for(int i=0; i<p; i++){
            x[i] = sc.nextInt();
        }
        int q = sc.nextInt();
        int[] y = new int[q];
        for(int i=0; i<q; i++){
            y[i] = sc.nextInt();
        }

        HashSet<Integer> set = new HashSet<>();
        for(int z : x) set.add(z);
        for(int z : y) set.add(z);

        boolean canThey = true;
        for(int i=1; i<=n; i++){
            if (set.contains(i)) continue;
            else{
                canThey = false;
                break;
            }
        }
        System.out.println(canThey? "I become the guy." : "Oh, my keyboard!");

    }
}