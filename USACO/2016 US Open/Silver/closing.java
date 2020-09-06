import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class closing {
    static boolean[] vis;
    static ArrayList<Integer>[] adj;
    static boolean[] closed;
    static int nodeCount = 0;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("closing.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("closing.out")));
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        vis = new boolean[n];
        adj = new ArrayList[n];
        closed = new boolean[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            add(a-1, b-1);
        }

        dfs(0);
        if (nodeCount < n) {
            out.println("NO");
        } else {
            out.println("YES");
        }
        nodeCount = 0;
        int nodes = n - 1;
        for (int i = 0; i < n - 1; i++) {
            Arrays.fill(vis, false);
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken()) - 1;
            closed[node] = true;
            dfs(returnIndexOpen());
            if (nodeCount < nodes) {
                out.println("NO");
            } else {
                out.println("YES");
            }
            nodeCount = 0;
            --nodes;
        }
        out.close();
        br.close();
    }

    public static void add(int a, int b) {
        adj[a].add(b);
        adj[b].add(a);
    }

    public static void dfs(int s) {
        vis[s] = true;
        ++nodeCount;
        for (int i = 0; i < adj[s].size(); i++) {
            if (!vis[adj[s].get(i)] && !closed[adj[s].get(i)]) {
                dfs(adj[s].get(i));
            }
        }
    }

    public static int returnIndexOpen() {
        for (int i = 0; i < closed.length; i++) {
            if (!closed[i]) {
                return i;
            }
        }
        return 0;
    }
}
