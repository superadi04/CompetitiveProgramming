import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class DanceMooves {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] line = new int[n];
        for (int i = 0; i < n; i++) {
            line[i] = i;
        }
        ArrayList<Integer>[] visited = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            visited[i] = new ArrayList<>();
        }
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            visited[line[a]].add(b);
            visited[line[b]].add(a);
            // Swap the 2 numbers
            int swap = line[a];
            line[a] = line[b];
            line[b] = swap;
        }
        int[] seq = new int[n];
        for (int i = 0; i < n; i++) {
            seq[line[i]] = i;
        }
        boolean[] vis = new boolean[n];
        int[] answers = new int[n];
        for (int i = 0; i < n; i++) {
            int index = i;
            ArrayList<Integer> nodes = new ArrayList<>();
            HashSet<Integer> currVis = new HashSet<>();
            while (!vis[index]) {
                vis[index] = true;
                nodes.add(index);
                currVis.addAll(visited[index]);
                index = seq[index];
            }
            for (int j : nodes) {
                answers[j] = currVis.size();
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n - 1; i++) {
            sb.append((answers[i] == 0) ? 1 : answers[i]).append("\n");
        }
        sb.append((answers[n - 1] == 0) ? 1 : answers[n - 1]);
        System.out.println(sb);
    }
}
