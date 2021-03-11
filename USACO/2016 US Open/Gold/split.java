import java.io.*;
import java.util.*;

public class split {
    static int n;
    static long initArea;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("split.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("split.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        Pair[] cows = new Pair[n];
        long maxX = 1;
        long minX = (long) 1e9;
        long maxY = 1;
        long minY = (long) 1e9;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            cows[i] = new Pair(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
            maxX = Math.max(maxX, cows[i].x);
            minX = Math.min(minX, cows[i].x);
            maxY = Math.max(maxY, cows[i].y);
            minY = Math.min(minY, cows[i].y);
        }
        initArea = (maxX - minX) * (maxY - minY);
        Arrays.sort(cows, Comparator.comparingLong(p -> p.x)); solve(cows);
        Arrays.sort(cows, Comparator.comparingLong(p -> p.y)); solve(cows);
        out.println(ans);
        out.close();
        br.close();
    }

    static long ans = 0;

    static void solve(Pair[] cows) {
        long[] left = new long[n];
        long[] right = new long[n];

        long maxX = 1;
        long minX = (long) 1e9;
        long maxY = 1;
        long minY = (long) 1e9;
        for (int i = 0; i < n; i++) {
            maxX = Math.max(maxX, cows[i].x);
            minX = Math.min(minX, cows[i].x);
            maxY = Math.max(maxY, cows[i].y);
            minY = Math.min(minY, cows[i].y);
            left[i] = (maxX - minX) * (maxY - minY);
        }

        maxX = 1;
        minX = (long) 1e9;
        maxY = 1;
        minY = (long) 1e9;
        for (int i = n - 1; i >= 0; i--) {
            maxX = Math.max(maxX, cows[i].x);
            minX = Math.min(minX, cows[i].x);
            maxY = Math.max(maxY, cows[i].y);
            minY = Math.min(minY, cows[i].y);
            right[i] = (maxX - minX) * (maxY - minY);
        }

        for (int i = 0; i < n - 1; i++) {
            ans = Math.max(ans, initArea - left[i] - right[i + 1]);
        }
    }

    static class Pair {
        long x, y;

        public Pair(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
}
