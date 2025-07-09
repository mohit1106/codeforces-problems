// https://codeforces.com/problemset/problem/1840/C

import java.util.*;
public class skiResort {
    public static long ncr(int n, int r){
        if(r>n-r) r= n-r;

        long res = 1;
        for(int i=0;i<r;i++){
            res*=(n-i);
            res/=(i+1);
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int q = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
                if(arr[i] <=q) arr[i]=1;
                else arr[i] = 0;
            }

            int count=0;
            long res= 0;

            for(int i=0;i<n;i++){
                if(arr[i]==1) {
                    count++;
                } else{
                    if(count>=k){
                        long len = count - k + 1;
                        res += len * (len + 1) / 2;
                    }
                    count=0;
                }
            }
            if(count>=k){
                long len = count - k + 1;
                res += len * (len + 1) / 2;
            }
            System.out.println(res);
        }        
    }
}