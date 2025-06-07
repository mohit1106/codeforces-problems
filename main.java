import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int answer = 0;
        for(int x=0; x<=n; x++){
            int count = 0;
            for(int i=0; i<n; i++){
                if(arr[i] >= x) count++;
            }
            if(count >= x){
                answer = x;
            }
        }
        System.out.println(answer);
    }
}