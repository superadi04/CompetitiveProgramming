import java.io.*;
import java.util.*;

public class SecretPasswords {
    static boolean[] vis;
    static ArrayList<Integer>[] adj;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        vis = new boolean[n];
        HashMap<Character, Integer> nodes = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < s.length(); j++) {
                if (nodes.containsKey(s.charAt(j))) {
                    adj[i].add(nodes.get(s.charAt(j)));
                    adj[nodes.get(s.charAt(j))].add(i);
                } else {
                    nodes.put(s.charAt(j), i);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(i);
                ans++;
            }
        }
        System.out.println(ans);
    }

    static void dfs(int n) {
        vis[n] = true;
        for (int i : adj[n]) {
            if (!vis[i]) dfs(i);
        }
    }
}
