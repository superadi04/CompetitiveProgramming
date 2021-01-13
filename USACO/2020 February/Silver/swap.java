import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class swap {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("swap.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("swap.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n, m, k;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        boolean[] vis = new boolean[n];
        int[][] seq = new int[m][2];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            seq[i][0] = Integer.parseInt(st.nextToken()) - 1;
            seq[i][1] = Integer.parseInt(st.nextToken()) - 1;
        }
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i;
        }
        int[] answers = new int[n];
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> cycle = new ArrayList<Integer>();
            int index = i;
            while (!vis[index]) {
                cycle.add(index);
                vis[index] = true;
                for (int j = 0; j < m; j++) {
                    if (index >= seq[j][0] && index <= seq[j][1]) {
                        index = -index + seq[j][0] + seq[j][1];
                    }
                }
            }
            for (int j = 0; j < cycle.size(); j++) {
                answers[cycle.get((j + k) % cycle.size())] = cycle.get(j);
            }
        }
        for (int i = 0; i < n; i++) {
            out.println(answers[i] + 1);
        }
        out.close();
        br.close();
    }
}
