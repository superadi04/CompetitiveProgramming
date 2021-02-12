import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class PerfectKeyboard {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        outer: for (int i = 0; i < t; i++) {
            String s = br.readLine();
            HashSet<Integer>[] set = new HashSet[26];
            HashSet<Integer> not = new HashSet<>();
            for (int j = 0; j < 26; j++) {
                set[j] = new HashSet<>();
                not.add(j);
            }
            for (int j = 0; j < s.length() - 1; j++) {
                set[s.charAt(j) - 97].add(s.charAt(j + 1) - 97);
                set[s.charAt(j + 1) - 97].add(s.charAt(j) - 97);
                not.remove(s.charAt(j) - 97);
                not.remove(s.charAt(j + 1) - 97);
            }
            int src = -1;
            for (int j = 0; j < 26; j++) {
                if (set[j].size() == 1 && s.length() > 1) {
                    src = j;
                }
                if (set[j].size() > 2) {
                    src = -1;
                    break;
                }
            }
            if (src == -1 && s.length() > 1) {
                System.out.println("NO");
                continue outer;
            }
            vis = new boolean[26];
            cycle = false;
            sb = new StringBuilder();
            if (s.length() > 1) dfs(src, set);
            if (cycle) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
                for (int j : not) {
                    sb.append((char) (j + 97));
                }
                System.out.println(sb);
            }
        }
    }

    static boolean[] vis;
    static boolean cycle = false;
    static StringBuilder sb;

    static void dfs(int n, HashSet<Integer>[] set) {
        if (vis[n]) {
            cycle = true;
            return;
        }
        vis[n] = true;
        sb.append((char) (n + 97));
        for (int i : set[n]) {
            if (!vis[i]) dfs(i, set);
        }
    }
}
