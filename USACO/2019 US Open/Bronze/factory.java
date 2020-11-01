import java.io.*;
import java.util.*;

public class factory {
    static ArrayList<Integer>[] adj;
    static boolean[] vis;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("factory.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("factory.out")));
        int n = Integer.parseInt(st.nextToken());
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        vis = new boolean[n];
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            add(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
        }

        int ans = -1;
        for (int i = 0; i < n; i++) {
            dfs(i);
            if (count == n) {
                ans = i + 1;
                break;
            }
            Arrays.fill(vis, false);
            count = 0;
        }
        out.print(ans);
        out.close();
        br.close();
    }

    public static void dfs(int n) {
        ++count;
        vis[n] = true;
        for (int i : adj[n]) {
            if (!vis[i]) dfs(i);
        }
    }

    public static void add(int a, int b) {
        adj[b].add(a);
    }
}
