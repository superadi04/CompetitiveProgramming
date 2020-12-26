import java.io.*;
import java.util.*;

public class diamond {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("diamond.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("diamond.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n, k;
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int[] diamonds = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            diamonds[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(diamonds);

        int a = 0, b = 0;
        int[] start = new int[n];
        int[] end = new int[n];

        Arrays.fill(start, 1);
        Arrays.fill(end, 1);

        while (a < n - 1) {
            if (diamonds[b] - diamonds[a] > k) {
                end[b - 1] = Math.max(end[b - 1], b - a);
                a++;
                b--;
            } else if (b < n - 1){
                b++;
                start[a] = Math.max(start[a], b - a);
            } else {
                start[a] = Math.max(start[a], b - a + 1);
                a++;
            }
        }

        for (int i = 1; i < n; i++) {
            end[i] = Math.max(end[i], end[i - 1]);
        }

        for (int i = n - 2; i >= 0; i--) {
            start[i] = Math.max(start[i], start[i + 1]);
        }

        int ans = 0;

        for (int i = 0; i < n - 1; i++) {
            ans = Math.max(ans, end[i] + start[i + 1]);
        }

        out.println(ans);
        out.close();
        br.close();
    }

    static class Pair implements Comparable<Pair> {
        int a, b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(a, o.a);
        }
    }
}
