import java.io.*;
import java.util.*;

public class B_Beautiful_String {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static void solve() {
        int n = in.nextInt();
            String s = in.next();
            
            StringBuilder x1 = new StringBuilder();
            for (char c : s.toCharArray()) if (c != '0') x1.append(c);
            StringBuilder x2 = new StringBuilder();
            for (char c : s.toCharArray()) if (c != '1') x2.append(c);
            
            if (isPalindrome(x1.toString())) {
                List<Integer> indices = new ArrayList<>();
                for (int i = 0; i < n; i++)
                    if (s.charAt(i) == '0') indices.add(i + 1);
                System.out.println(indices.size());
                if (!indices.isEmpty())
                    System.out.println(indices.toString().replaceAll("[\\[\\],]", ""));
            } else if (isPalindrome(x2.toString())) {
                List<Integer> indices = new ArrayList<>();
                for (int i = 0; i < n; i++)
                    if (s.charAt(i) == '1') indices.add(i + 1);
                System.out.println(indices.size());
                if (!indices.isEmpty())
                    System.out.println(indices.toString().replaceAll("[\\[\\],]", ""));
            } else {
                System.out.println(-1);
            }
    }

    public static boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++; r--;
        }
        return true;
    }

    static class FastReader {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try { st = new StringTokenizer(br.readLine()); }
                catch (IOException e) { e.printStackTrace(); }
            }
            return st.nextToken();
        }
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }
        String nextLine() {
            String str = "";
            try { str = br.readLine(); }
            catch (IOException e) { e.printStackTrace(); }
            return str;
        }
    }
}