import java.io.*;
import java.util.*;

public class mootube {
    static ArrayList<Video>[] adj;
    static boolean[] vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("mootube.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mootube.out")));
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        vis = new boolean[n];
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Video>();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            add(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken()) - 1;
            out.println(dfs(v, k, Integer.MAX_VALUE));
            Arrays.fill(vis, false);
        }
        out.close();
        br.close();
    }

    public static int dfs(int n, int k, int rel) {
        int ans = 0;
        vis[n] = true;
        for (Video v : adj[n]) {
            if (!vis[v.node] && Math.min(rel, v.weight) >= k) {
                ans += dfs(v.node, k, Math.min(rel, v.weight)) + 1;
            }
        }
        return ans;
    }

    public static void add(int p, int q, int r) {
        adj[p].add(new Video(q, r));
        adj[q].add(new Video(p, r));
    }

    static class Video {
        int node;
        int weight;

        public Video(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
}