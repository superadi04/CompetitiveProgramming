import java.io.*;
import java.util.*;

public class stacking {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("combo.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] counts = new int[n];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        PriorityQueue<Integer> curr = new PriorityQueue<Integer>();
        for (int i = 0; i < n; i++) {
            while (!pq.isEmpty() && pq.peek().start == i + 1) {
                curr.add(pq.poll().end);
            }
            counts[i] += curr.size();
            while (!curr.isEmpty() && curr.peek() == i + 1) {
                curr.poll();
            }
        }
        Arrays.sort(counts);
        out.print(counts[n / 2]);
        out.close();
        br.close();
    }

    static class Pair implements Comparable<Pair> {
        int start;
        int end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Pair o) {
            return Integer.compare(start, o.start);
        }
    }
}
