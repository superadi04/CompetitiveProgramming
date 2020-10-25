import java.io.*;
import java.util.*;

public class milkvisits {
    static int n, m;
    static String milk;
    static ArrayList<Integer>[] adj;
    static boolean[] vis;
    static int[] comp;
    static int max = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("milkvisits.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        adj = new ArrayList[n]; vis = new boolean[n]; comp = new int[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        st = new StringTokenizer(br.readLine());
        milk = st.nextToken();
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            add(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
        }
        dfs(0, 0, max);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1, b = Integer.parseInt(st.nextToken()) - 1;
            char c = st.nextToken().charAt(0);
            if (comp[a] != comp[b]) {
                out.print(1);
            } else {
                if (milk.charAt(a) == c) {
                    out.print(1);
                } else {
                    out.print(0);
                }
            }
        }
        out.close();
        br.close();
    }

    static void dfs(int x, int prev, int count) {
        if (milk.charAt(prev) != milk.charAt(x)) {
            comp[x] = ++max;
            count = max;
        } else {
            comp[x] = count;
        }
        vis[x] = true;
        for (int i : adj[x]) {
            if (!vis[i]) {
                dfs(i, x, count);
            }
        }
    }

    static void add(int a, int b) {
        adj[a].add(b);
        adj[b].add(a);
    }
}
