import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class wormsort {
    static int[] cows;
    static ArrayList<Pair>[] adj;
    static boolean[] vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("wormsort.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("wormsort.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n, m;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        cows = new int[n];
        adj = new ArrayList[n];
        vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cows[i] = Integer.parseInt(st.nextToken()) - 1;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a, b, w;
            a = Integer.parseInt(st.nextToken()) - 1;
            b = Integer.parseInt(st.nextToken()) - 1;
            w = Integer.parseInt(st.nextToken());
            adj[a].add(new Pair(b, w));
            adj[b].add(new Pair(a, w));
        }
        int lo = 0, hi = (int) 1E9;
        while (lo < hi) {
            int mid = (lo + hi + 1) / 2;
            if (check(mid)) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
            Arrays.fill(vis, false);
        }
        out.print((lo == (int) 1E9) ? -1 : lo);
        out.close();
        br.close();
    }

    static boolean check(int x) {
        dfs(0, x);
        for (int i = 0; i < vis.length; i++) {
            if ((!vis[i] || !vis[cows[i]]) && i != cows[i]) {
                return false;
            }
        }
        return true;
    }

    static void dfs(int n, int x) {
        if (vis[n]) return;
        vis[n] = true;
        for (Pair p : adj[n]) {
            if (p.width >= x) {
                dfs(p.loc, x);
            }
        }
    }

    static class Pair {
        int loc, width;

        public Pair(int loc, int width) {
            this.loc = loc;
            this.width = width;
        }
    }
}
