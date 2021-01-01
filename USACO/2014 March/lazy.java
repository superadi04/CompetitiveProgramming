import java.io.*;
import java.util.*;

public class lazy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("lazy.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lazy.out")));
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Pair[] patches = new Pair[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            patches[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(patches);
        int[] pref = new int[patches[n - 1].x + 2];
        if (k >= patches[n - 1].x / 2) k = patches[n - 1].x / 2;
        int index = 0;
        for (int i = 0; i < pref.length - 1; i++) {
            int cnt = 0;
            if (i == patches[index].x) {
                cnt = patches[index].g;
                ++index;
            }
            pref[i + 1] += pref[i] + cnt;
        }
        int ans = 0;
        for (int i = k + 1; i < pref.length - k; i++) {
            ans = Math.max(ans, pref[i + k] - pref[i - k - 1]);
        }
        out.print(ans);
        out.close();
        br.close();
    }

    static class Pair implements Comparable<Pair> {
        int g;
        int x;

        public Pair(int g, int x) {
            this.g = g;
            this.x = x;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(x, o.x);
        }
    }
}
