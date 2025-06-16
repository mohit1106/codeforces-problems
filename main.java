// https://codeforces.com/problemset/problem/1838/C
// https://codeforces.com/problemset/problem/2002/C
import java.util.*;
public class Main {

    public static void subset(int[] arr, int i, String res){
        if( i>= arr.length){
            System.out.println(res);
            return;
        }
        subset(arr, i+1, res+arr[i]);
        subset(arr, i+1, res);
        
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        String res = "";
        subset(arr, 0, res);
    }
}