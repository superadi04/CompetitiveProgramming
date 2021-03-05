import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class clocktree {
    static ArrayList<Integer>[] adj;
    static int[] times;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("clocktree.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("clocktree.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        times = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            times[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            adj[a].add(b);
            adj[b].add(a);
        }
        int count = 0;
        outer: for (int i = 0; i < n; i++) {
            tempTimes = times.clone();
            tempTimes[i]--;
            dfs(i, i);
            for (int j : tempTimes) {
                if (j != 12 && j != 1) {
                    continue outer;
                }
            }
            count++;
        }
        out.println(count);
        out.close();
        br.close();
    }

    static int[] tempTimes;

    static int dfs(int parent, int current) {
        tempTimes[current]++;
        for (int i : adj[current]) {
            if (i != parent) {
                tempTimes[current] = (tempTimes[current] + dfs(current, i)) % 12 + 1;
                tempTimes[i] = 12;
            }
        }
        return 12 - tempTimes[current];
    }
}
