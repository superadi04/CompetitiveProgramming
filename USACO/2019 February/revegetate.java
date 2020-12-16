import java.io.*;
import java.util.*;

public class revegetate {
    static ArrayList<Pair>[] adj;
    static boolean vis[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("revegetate.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("revegetate.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n, m;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        adj = new ArrayList[n];
        vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        fields = new int[n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            char type = st.nextToken().charAt(0);
            int n1 = Integer.parseInt(st.nextToken()) - 1;
            int n2 = Integer.parseInt(st.nextToken()) - 1;
            adj[n1].add(new Pair(n2, type));
            adj[n2].add(new Pair(n1, type));
        }

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                if (adj[i].size() >= 1) {
                    fields[i] = 1;
                    dfs(adj[i].get(0).node, 1, adj[i].get(0).type);
                }
                if (impossible) {
                    break;
                } else {
                    ans++;
                }
            }
        }
        if (impossible) {
            out.print(0);
        } else {
            out.print(1);
            for (int i = 0; i < ans; i++) {
                out.print(0);
            }
        }
        out.close();
        br.close();

    }

    static void dfs(int n, int prevType, char need) {
        if (vis[n]) return;
        vis[n] = true;
        if (need == 'S') {
            fields[n] = prevType;
        } else {
            fields[n] = Math.abs(prevType - 3);
        }
        for (Pair p : adj[n]) {
            if (vis[p.node] && ((p.type == 'D' && fields[n] == fields[p.node]) || (p.type == 'S' && fields[n] != fields[p.node]))) {
                impossible = true;
                return;
            } else {
                dfs(p.node, fields[n], p.type);
            }
        }
    }

    static int ans = 0;
    static boolean impossible = false;
    static int[] fields;

    static class Pair {
        int node;
        char type;

        public Pair(int node, char type) {
            this.node = node;
            this.type = type;
        }
    }
}
