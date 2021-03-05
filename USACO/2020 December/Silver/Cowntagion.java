import java.io.*;
import java.util.*;

public class Cowntagion {
    static ArrayList<Integer>[] adj;
    static boolean[] vis;
    static int days = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        adj = new ArrayList[n];
        vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            adj[a].add(b);
            adj[b].add(a);
        }
        dfs(0);
        System.out.println(days);
        br.close();
    }

    static void dfs(int n) {
        if (vis[n]) return;
        vis[n] = true;
        days++;
        int cows = 1;
        int size = 0;
        for (int i : adj[n]) if (!vis[i]) size++;
        while (cows <= size) {
            cows *= 2;
            days++;
        }
        for (int i : adj[n]) if (!vis[i]) dfs(i);
    }
}
