// https://codeforces.com/contest/344/problem/A

import java.util.*;;
public class magnets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] input = new String[n];
        for(int i=0; i<n; i++){
            input[i] = sc.next();
        }
        int groups = 1;
        int i = 0;
        while(i<n-1){
            if(input[i].equals(input[i+1])){
                i++;
            }
            else{
                groups++;
                i++;
            }
        }
        System.out.println(groups);
        
    }
}
