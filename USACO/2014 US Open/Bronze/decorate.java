import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class decorate {
    static int n, m;
    static ArrayList<Integer>[] adj;
    static boolean[] vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("decorate.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("decorate.out")));

        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        adj = new ArrayList[n];
        vis = new boolean[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1; int b = Integer.parseInt(st.nextToken()) - 1;
            adj[a].add(b);
            adj[b].add(a);
        }
        color = new int[n];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(i, 1);
                ans += Math.max(answers[0], answers[1]);
            }
            if (impossible) {
                break;
            }
            answers = new int[2];
        }
        if (impossible) {
            out.println(-1);
        } else {
            out.println(ans);
        }
        out.close();
        br.close();
    }

    static int[] answers = new int[2];

    static void dfs(int n, int currCol) {
        if (impossible) return;
        if (vis[n]) {
            if (color[n] != currCol) impossible = true;
            return;
        }
        color[n] = currCol;
        answers[currCol - 1]++;
        vis[n] = true;
        for (int i : adj[n]) {
            dfs(i, Math.abs(currCol - 3));
        }
    }

    static boolean impossible = false;
    static int[] color;
}
