// https://codeforces.com/contest/263/problem/A

import java.util.*;
public class beautifulMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = -1, col = -1;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int num = sc.nextInt();
                if (num == 1) {
                    row = i;
                    col = j;
                }
            }
            sc.nextLine();
        }
        int totalMoves = Math.abs(row - 2) + Math.abs(col - 2);
        System.out.println(totalMoves);
    }
}
