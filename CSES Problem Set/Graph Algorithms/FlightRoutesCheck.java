import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class FlightRoutesCheck {
    static ArrayList<Integer>[] adj;
    static ArrayList<Integer>[] adj2;
    static boolean[] vis;
    static boolean[] vis2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        vis = new boolean[n];
        vis2 = new boolean[n];
        adj = new ArrayList[n];
        adj2 = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
            adj2[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            adj[a].add(b);
            adj2[b].add(a);
        }
        dfs(vis, adj, 0);
        dfs(vis2, adj2, 0);
        int connected = -1, nonconnected = -1;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                nonconnected = i + 1;
            } else {
                connected = i + 1;
            }
        }
        int connected2 = -1, nonconnected2 = -1;
        for (int i = 0; i < n; i++) {
            if (!vis2[i]) {
                nonconnected2 = i + 1;
            } else {
                connected2 = i + 1;
            }
        }
        if (nonconnected != -1) {
            System.out.println("NO\n" + connected + " " + nonconnected);
        } else if (nonconnected2 != -1) {
            System.out.println("NO\n" + nonconnected2 + " " + connected2);
        } else {
            System.out.println("YES");
        }
    }

    static void dfs(boolean[] vis, ArrayList<Integer>[] adj, int node) {
        vis[node] = true;
        for (int i : adj[node]) {
            if (!vis[i]) {
                dfs(vis, adj, i);
            }
        }
    }
}
