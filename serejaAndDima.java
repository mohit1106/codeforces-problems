/// https://codeforces.com/contest/381/problem/A

import java.util.*;
public class serejaAndDima {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int sereja = 0;
        int dima = 0;
        int left = 0;
        int right = n-1;
        boolean serejaturn = true;
        while(left <= right){
            int choosen;
            if(arr[left] > arr[right]){
                choosen = arr[left];
                left++;
            } else{
                choosen = arr[right];
                right--;
            }
            if(serejaturn){
                sereja += choosen;
            } else{
                dima += choosen;
            }
            serejaturn = !serejaturn;
        }
        // for(int i=0; i<n; i++) {
        //     if(serejaturn == 1 && dimaturn == 0){
        //         if(arr[i]>arr[n-i-1]){
        //             sereja += arr[i];
        //         } else{
        //             sereja += arr[n-i-1];
        //         }
        //     }
        //     else if(dimaturn == 1 && serejaturn == 0){
        //         if(arr[i]>arr[n-i-1]){
        //             dima += arr[i];
        //         } else{
        //             dima += arr[n-i-1];
        //         }
        //     }
        //     serejaturn = 0;
        //     dimaturn =1;

        // }
        System.out.println(sereja + " " + dima);
    }
}