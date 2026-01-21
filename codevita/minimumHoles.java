import java.util.*;

public class minimumHoles {
    static class UF {
        int[] parent;
        UF(int size) {
            parent = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }
        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        void union(int x, int y) {
            int px = find(x), py = find(y);
            if (px != py) {
                parent[px] = py;
            }
        }
    }

    static class Bounds {
        int minr = Integer.MAX_VALUE;
        int maxr = Integer.MIN_VALUE;
        int minc = Integer.MAX_VALUE;
        int maxc = Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int N = sc.nextInt();

        TreeSet<Integer> xs = new TreeSet<>();
        xs.add(0);
        xs.add(n);
        TreeSet<Integer> ys = new TreeSet<>();
        ys.add(0);
        ys.add(m);

        Map<Integer, List<int[]>> vert = new TreeMap<>();
        Map<Integer, List<int[]>> horiz = new TreeMap<>();

        boolean inputValid = true;
        for (int i = 0; i < N; i++) {
            int x1 = sc.nextInt(), y1 = sc.nextInt(), x2 = sc.nextInt(), y2 = sc.nextInt();
            xs.add(x1);
            xs.add(x2);
            ys.add(y1);
            ys.add(y2);
            if (x1 == x2) {
                // vertical
                int yy1 = Math.min(y1, y2);
                int yy2 = Math.max(y1, y2);
                vert.computeIfAbsent(x1, k -> new ArrayList<>()).add(new int[]{yy1, yy2});
            } else if (y1 == y2) {
                // horizontal
                int xx1 = Math.min(x1, x2);
                int xx2 = Math.max(x1, x2);
                horiz.computeIfAbsent(y1, k -> new ArrayList<>()).add(new int[]{xx1, xx2});
            } else {
                inputValid = false;
            }
        }
        sc.close();

        if (!inputValid) {
            System.out.println("Invalid");
            return;
        }

        List<Integer> X = new ArrayList<>(xs);
        List<Integer> Y = new ArrayList<>(ys);
        int W = X.size() - 1;
        int H = Y.size() - 1;

        boolean valid = true;
        for (int i = 0; i < W; i++) {
            if (X.get(i + 1) <= X.get(i)) valid = false;
        }
        for (int i = 0; i < H; i++) {
            if (Y.get(i + 1) <= Y.get(i)) valid = false;
        }
        if (!valid || W <= 0 || H <= 0) {
            System.out.println("Invalid");
            return;
        }

        int cells = W * H;
        UF uf = new UF(cells);

        // Horizontal unions (connect rows in same column if not separated)
        for (int i = 0; i < W; i++) {
            for (int j = 0; j < H - 1; j++) {
                int ywall = Y.get(j + 1);
                boolean separated = false;
                if (horiz.containsKey(ywall)) {
                    for (int[] seg : horiz.get(ywall)) {
                        if (seg[0] <= X.get(i) && seg[1] >= X.get(i + 1)) {
                            separated = true;
                            break;
                        }
                    }
                }
                if (!separated) {
                    int id1 = j * W + i;
                    int id2 = (j + 1) * W + i;
                    uf.union(id1, id2);
                }
            }
        }

        // Vertical unions (connect columns in same row if not separated)
        for (int j = 0; j < H; j++) {
            for (int i = 0; i < W - 1; i++) {
                int xwall = X.get(i + 1);
                boolean separated = false;
                if (vert.containsKey(xwall)) {
                    for (int[] seg : vert.get(xwall)) {
                        if (seg[0] <= Y.get(j) && seg[1] >= Y.get(j + 1)) {
                            separated = true;
                            break;
                        }
                    }
                }
                if (!separated) {
                    int id1 = j * W + i;
                    int id2 = j * W + (i + 1);
                    uf.union(id1, id2);
                }
            }
        }

        // Assign roots to grid
        int[][] grid = new int[H][W];
        for (int j = 0; j < H; j++) {
            for (int i = 0; i < W; i++) {
                int id = j * W + i;
                grid[j][i] = uf.find(id);
            }
        }

        // Validate rectangles
        Map<Integer, Integer> counts = new HashMap<>();
        Map<Integer, Bounds> boundsMap = new HashMap<>();
        for (int j = 0; j < H; j++) {
            for (int i = 0; i < W; i++) {
                int r = grid[j][i];
                counts.put(r, counts.getOrDefault(r, 0) + 1);
                Bounds b = boundsMap.computeIfAbsent(r, k -> new Bounds());
                b.minr = Math.min(b.minr, j);
                b.maxr = Math.max(b.maxr, j);
                b.minc = Math.min(b.minc, i);
                b.maxc = Math.max(b.maxc, i);
            }
        }

        valid = true;
        for (int r : counts.keySet()) {
            int cnt = counts.get(r);
            Bounds b = boundsMap.get(r);
            int rows = b.maxr - b.minr + 1;
            int cols = b.maxc - b.minc + 1;
            int expected = rows * cols;
            if (cnt != expected || expected <= 0) {
                valid = false;
                break;
            }
        }

        if (!valid) {
            System.out.println("Invalid");
            return;
        }

        // Now compute number of merged wall pieces
        int totalHoles = 0;

        // Merge vertical intervals per x
        for (int key : vert.keySet()) {
            List<int[]> intervals = vert.get(key);
            if (intervals.isEmpty()) continue;
            Collections.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
            List<int[]> merged = new ArrayList<>();
            int[] curr = intervals.get(0);
            for (int k = 1; k < intervals.size(); k++) {
                int[] next = intervals.get(k);
                if (curr[1] >= next[0]) {
                    curr[1] = Math.max(curr[1], next[1]);
                } else {
                    merged.add(curr);
                    curr = next;
                }
            }
            merged.add(curr);
            totalHoles += merged.size();
        }

        // Merge horizontal intervals per y
        for (int key : horiz.keySet()) {
            List<int[]> intervals = horiz.get(key);
            if (intervals.isEmpty()) continue;
            Collections.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
            List<int[]> merged = new ArrayList<>();
            int[] curr = intervals.get(0);
            for (int k = 1; k < intervals.size(); k++) {
                int[] next = intervals.get(k);
                if (curr[1] >= next[0]) {
                    curr[1] = Math.max(curr[1], next[1]);
                } else {
                    merged.add(curr);
                    curr = next;
                }
            }
            merged.add(curr);
            totalHoles += merged.size();
        }

        System.out.println(totalHoles);
    }
}