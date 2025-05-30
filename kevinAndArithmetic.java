// https://codeforces.com/problemset/problem/2061/A

import java.util.*;
public class kevinAndArithmetic {

    public static int countDivision(int num){
        int count = 0;
        while(num%2 == 0){
            count++;
            num = num/2;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int i=0; i<n; i++){
                a[i] = sc.nextInt();
            }

            Integer[] b = Arrays.stream(a).boxed().toArray(Integer[] :: new);
            Arrays.sort(b, (x,y) -> Integer.compare(countDivision(y), countDivision(x)));

            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = b[i];
            }

            int sum = 0, points = 0;
            for(int i=0; i<n; i++){
                sum = sum + arr[i];
                if(sum % 2 == 0){
                    points++;
                    while(sum % 2 == 0){
                        sum = sum / 2;
                    }
                }
            }
            System.out.println(points);
        }
    }
}