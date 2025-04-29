// https://codeforces.com/contest/427/problem/A

import java.util.*;
public class policeRecruits {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int police = 0;
        // int criminals = 0;
        int crime = 0;

        for(int yu : arr){
            if(yu == -1){
                if(police > 0){
                    police--;
                } else{
                    crime++;
                }
            } else{
                police += yu;
            }

            // if(police < criminals){
            //     crime++;
            //     criminals--;
            // } else{
            //     police = police-criminals;
            // }
        }
        System.out.println(crime);
    }
}