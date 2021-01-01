import java.io.*;
import java.util.*;

public class countcross {
    static int n, k, r;

    static HashSet<Pair>[][] roads;
    static boolean[][] vis;
    static boolean[][] cows;

    static int cowsCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("countcross.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("countcross.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        roads = new HashSet[n][n];
        vis = new boolean[n][n];
        cows = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                roads[i][j] = new HashSet<Pair>();
            }
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken()) - 1;
            int c1 = Integer.parseInt(st.nextToken()) - 1;
            int r2 = Integer.parseInt(st.nextToken()) - 1;
            int c2 = Integer.parseInt(st.nextToken()) - 1;
            roads[r1][c1].add(new Pair(r2, c2));
            roads[r2][c2].add(new Pair(r1, c1));
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            cows[r][c] = true;
        }
        //floodfill(2, 2);
        ArrayList<Integer> compcounts = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j]) {
                    floodfill(i, j);
                    compcounts.add(cowsCount);
                    cowsCount = 0;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < compcounts.size() - 1; i++) {
            for (int j = i + 1; j < compcounts.size(); j++) {
                ans += compcounts.get(i) * compcounts.get(j);
            }
        }
        out.print(ans);
        out.close();
        br.close();
    }

    static void floodfill(int r, int c) {
        if (r < 0 || r >= n || c < 0 || c >= n) return;
        if (vis[r][c]) return;
        vis[r][c] = true;
        if (cows[r][c]) cowsCount++;

        if (!roads[r][c].contains(new Pair(r, c+1))) floodfill(r, c+1);
        if (!roads[r][c].contains(new Pair(r, c-1))) floodfill(r, c-1);
        if (!roads[r][c].contains(new Pair(r-1, c))) floodfill(r-1, c);
        if (!roads[r][c].contains(new Pair(r+1, c))) floodfill(r+1, c);
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return x * 31 + y * 31;
        }

        @Override
        public boolean equals(Object p) {
            Pair o = (Pair) p;
            return x == o.x && y == o.y;
        }
    }
}
