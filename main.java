import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long K = sc.nextLong();

        long[] A = new long[N];
        long[] B = new long[N];
        int[] C = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextLong();
            B[i] = sc.nextLong();
            C[i] = sc.nextInt();
        }
        sc.close();

        int[] enter = new int[N];
        Arrays.fill(enter, -1);

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o[0]));
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        long inside = 0;
        int admittedCount = 0;
        int idx = 0; 
        long INF = Long.MAX_VALUE / 4;
        long currentTime = 0;

        while (admittedCount < N) {
            long nextArrival = (idx < N) ? A[idx] : INF;
            long nextDeparture = (!pq.isEmpty()) ? pq.peek()[0] : INF;
            long t = Math.min(nextArrival, nextDeparture);
            currentTime = t;

            while (!pq.isEmpty() && pq.peek()[0] <= currentTime) {
                long[] ev = pq.poll();
                inside -= ev[1];
            }

            while (idx < N && A[idx] == currentTime) {
                queue.addLast(idx);
                idx++;
            }

            while (!queue.isEmpty()) {
                int front = queue.peekFirst();
                int need = C[front];
                if (inside + need <= K) {
                    queue.pollFirst();
                    enter[front] = (int) currentTime;
                    inside += need;
                    pq.add(new long[]{currentTime + B[front], need});
                    admittedCount++;
                } else {
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(enter[i]).append('\n');
        }
        System.out.print(sb.toString());
    }
}
