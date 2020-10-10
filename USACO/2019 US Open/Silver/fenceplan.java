import java.io.*;
import java.util.*;

public class fenceplan {
    static boolean[] vis;
    static ArrayList<Cow>[] adj;
    static TreeSet<Integer> set = new TreeSet<Integer>();
    static Cow[] cows;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("fenceplan.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("fenceplan.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodes = Integer.parseInt(st.nextToken());
        int edges = Integer.parseInt(st.nextToken());
        vis = new boolean[nodes];
        adj = new ArrayList[nodes];
        cows = new Cow[nodes];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<Cow>();
        }
        for (int i = 0; i < nodes; i++) {
            st = new StringTokenizer(br.readLine());
            cows[i] = new Cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i);
        }
        for (int i = 0; i < edges; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            add(a, b);
            set.add(a);
            set.add(b);
        }
        int ans = Integer.MAX_VALUE;
        while (set.size() != 0) {
             ans  = Math.min(ans, dfs(set.first(), Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 0));
        }
        out.print(ans);
        out.close();
        br.close();
    }

    public static int dfs(int node, int minx, int maxx, int miny, int maxy) {
        minx = Math.min(minx, cows[node].x);
        maxx = Math.max(maxx, cows[node].x);
        miny = Math.min(miny, cows[node].y);
        maxy = Math.max(maxy, cows[node].y);
        int ans = 0;
        vis[node] = true;
        set.remove(node);
        for (Cow neighbor : adj[node]) {
            if (!vis[neighbor.i]) {
                ans = Math.max(ans, dfs(neighbor.i, minx, maxx, miny, maxy));
            }
        }
        return Math.max(ans, 2 * ((maxx - minx) + (maxy - miny)));
    }

    public static void add(int a, int b) {
        adj[a].add(cows[b]);
        adj[b].add(cows[a]);
    }

    static class Cow {
        int x;
        int y;
        int i;

        public Cow(int x, int y, int i) {
            this.x = x;
            this.y = y;
            this.i = i;
        }
    }

}
