import java.io.*;
import java.util.*;

public class shuffle {
    static ArrayList<Integer>[] adj;
    static int[] counts;
    static boolean[] vis;
    static int ans = 0;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("shuffle.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("shuffle.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        adj = new ArrayList[n];
        counts = new int[n];
        vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            adj[i].add(Integer.parseInt(st.nextToken()) - 1);
        }
        for (int i = 0; i < n; i++) {
            if (!vis[i]) dfs(i);
            currvis = new HashSet<>();
        }
        out.println(ans);
        out.close();
    }

    static HashSet<Integer> currvis = new HashSet<>();

    static void dfs(int n) {
        if (vis[n]) {
            if (currvis.contains(n)) {
                ans += (count - counts[n]) + 1;
                counts[n] = count;
            }
            return;
        }
        vis[n] = true;
        currvis.add(n);
        count++;
        counts[n] = count;
        for (int a : adj[n]) {
            dfs(a);
        }
    }
}
