import java.io.*;
import java.util.*;

public class moocast {
    static Pair[] points;
    static boolean[] vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("moocast.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("moocast.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        points = new Pair[n];
        vis = new boolean[n];

        // Store each point as a Pair w/ its respective number
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            points[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i);
        }

        // Binary search on the answer!
        int lo = 0, hi = (int) 1E9;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            dfs(0, mid);
            if (count < n) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
            count = 0;
            vis = new boolean[n];
        }

        // Our answer.
        out.println(lo);
        out.close();
        br.close();
    }

    static int count = 0; // Count how many points we have visited

    static void dfs(int n, int x) {
        if (vis[n]) return;
        vis[n] = true;
        count++;
        for (Pair p : points) {
            // If we have not visited this point and if this point is within the range of sqrt(x), visit it
            if (!vis[p.n] && Math.abs(points[n].x - p.x) * Math.abs(points[n].x - p.x) + Math.abs(points[n].y - p.y) * Math.abs(points[n].y - p.y) <= x) {
                dfs(p.n, x);
            }
        }
    }

    static class Pair {
        int x, y, n;

        public Pair(int x, int y, int n) {
            this.x = x;
            this.y = y;
            this.n = n;
        }
    }
}
