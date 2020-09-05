import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SocialNetworkingGraph {
    static ArrayList<Integer>[] adj;
    static boolean[] vis;
    static int[] level;
    static Queue<Integer> q = new LinkedList<Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodes = Integer.parseInt(st.nextToken());
        int edges = Integer.parseInt(st.nextToken());
        vis = new boolean[nodes];
        level = new int[nodes];
        adj = new ArrayList[nodes];
        for (int i = 0; i < nodes; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < edges; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            add(a, b);
        }
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            int n = 0;
            Arrays.fill(vis, false);
            Arrays.fill(level, 0);
            bfs(src);
            for (int k : level) {
                if (Math.abs(k - level[src]) == dist) {
                    ++n;
                }
            }
            System.out.println(n);
        }
    }

    public static void add(int a, int b) {
        adj[a].add(b);
        adj[b].add(a);
    }

    public static void bfs(int s) {
        q.add(s);
        vis[s] = true;
        while (!q.isEmpty()) {
            int p = q.poll();
            for (int i = 0; i < adj[p].size(); i++) {
                if (!vis[adj[p].get(i)]) {
                    level[adj[p].get(i)] = level[p] + 1;
                    q.add(adj[p].get(i));
                    vis[adj[p].get(i)] = true;
                }
            }
        }
    }
}
