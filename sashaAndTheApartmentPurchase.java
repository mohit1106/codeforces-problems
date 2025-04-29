// https://codeforces.com/contest/2098/problem/B


import java.util.*;
public class sashaAndTheApartmentPurchase {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            Arrays.sort(arr);
            int openBars = n-k;
            int leftPos = (openBars - 1)/2;
            int rightPos = n-leftPos-1;

            int answer = arr[rightPos] - arr[leftPos] + 1;
            System.out.println(answer);

        }
    }
}

