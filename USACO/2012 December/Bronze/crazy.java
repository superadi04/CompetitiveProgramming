import java.io.*;
import java.util.*;

public class crazy {
    static boolean[][] vis;
    static boolean[][] isCow;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("crazy.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("crazy.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        Pasture[] pastures = new Pasture[n];
        Cow[] cows = new Cow[c];

        TreeSet<Integer> vals = new TreeSet<Integer>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            pastures[i] = new Pasture(x1, y1, x2, y2);
            vals.add(x1);
            vals.add(y1);
            vals.add(x2);
            vals.add(y2);
        }

        for (int i = 0; i < c; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            cows[i] = new Cow(x, y);
            vals.add(x);
            vals.add(y);
        }

        // Coordinate compress all of the cows from values from 0-500
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int count = 0;
        for (Integer i : vals) {
            if (!map.containsKey(i)) {
                map.put(i, count);
                count += 2;
            }
        }

        // Maximum size of grid will be n by n after coordinate compression
        vis = new boolean[count][count];

        for (Pasture p : pastures) {
            int x1 = map.get(p.x1);
            int y1 = map.get(p.y1);
            int x2 = map.get(p.x2);
            int y2 = map.get(p.y2);
            if (x1 - x2 != 0) {
                for (int i = Math.min(x1, x2); i <= Math.max(x1, x2); i++) {
                    vis[y1][i] = true;
                }
            } else {
                for (int i = Math.min(y1, y2); i <= Math.max(y1, y2); i++) {
                    vis[i][x1] = true;
                }
            }
        }

        isCow = new boolean[count][count];
        // Now we do the same for all of the cows, placing them onto the n by n grid isCow
        // Since there is no cow touching a fence, we should not have any problems, as
        // the compressed coordinates of the cows are distinct from the compressed coordinates of the fences
        for (Cow a : cows) {
            isCow[map.get(a.y)][map.get(a.x)] = true;
        }

        // Now we perform floodfill
        int ans = 0;
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                if (!vis[i][j]) {
                    floodfill(i, j);
                    ans = Math.max(ans, countCows);
                    countCows = 0;
                }
            }
        }

        out.println(ans);
        out.close();
        br.close();
    }

    static int countCows = 0;

    static void floodfill(int r, int c) {
        if (r < 0 || r >= vis.length || c < 0 || c >= vis.length) return;
        if (vis[r][c]) return;
        vis[r][c] = true;
        if (isCow[r][c]) countCows++;
        floodfill(r, c + 1);
        floodfill(r, c - 1);
        floodfill(r - 1, c);
        floodfill(r + 1, c);
    }

    static class Cow {
        int x, y;

        public Cow(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Pasture {
        int x1, y1, x2, y2;

        public Pasture(int x1, int y1, int x2, int y2) {
            this.x1 = Math.min(x1, x2);
            this.x2 = Math.max(x1, x2);
            this.y1 = Math.min(y1, y2);
            this.y2 = Math.max(y1, y2);
        }
    }
}
