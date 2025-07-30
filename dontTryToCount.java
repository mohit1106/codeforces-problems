// https://codeforces.com/problemset/problem/1881/A
import java.util.*;

public class dontTryToCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(), m = sc.nextInt();
            String x = sc.next(), s = sc.next();

            if (x.contains(s)) {
                System.out.println(0);
                continue;
            }

            String tStr = x;
            boolean found = false;
            for (int ops = 1; ops <= 6; ops++) {
                tStr = tStr + tStr;             
                if (tStr.contains(s)) {
                    System.out.println(ops);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println(-1);
            }
        }
    }
}
