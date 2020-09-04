import java.io.*;
import java.util.*;

public class MonkAndTheIslands {
    static ArrayList<Integer>[] adj;
    static Queue<Integer> q = new LinkedList<Integer>();
    static boolean[] vis;
    static int[] level;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int nodes = Integer.parseInt(st.nextToken());
            int edges = Integer.parseInt(st.nextToken());
            adj = new ArrayList[nodes];
            for (int j = 0; j < nodes; j++) {
                adj[j] = new ArrayList<Integer>();
            }
            vis = new boolean[nodes];
            level = new int[nodes];
            for (int j = 0; j < edges; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;
                add(a, b);
            }
            bfs(0);
            System.out.println(level[nodes-1]);
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