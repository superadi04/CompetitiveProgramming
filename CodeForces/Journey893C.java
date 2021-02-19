import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Journey893C {
    static ArrayList<Integer>[] adj;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        adj = new ArrayList[n];
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
        dfs(0, 0, 1, 0);
        System.out.println(ans);
    }

    static double ans = 0;

    static void dfs(int c, int p, double prob, int size) {
        boolean test = true;
        for (int i : adj[c]) {
            if (i != p) {
                test = false;
                dfs(i, c, prob * (1.0 / ((c != 0) ? adj[c].size() - 1 : adj[c].size())), size + 1);
            }
        }
        if (test) {
            ans += prob * size;
        }
    }
}
