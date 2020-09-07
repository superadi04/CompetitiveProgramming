import java.io.*;
import java.util.*;

public class moocast {
    static Cow[] cows;
    static boolean[] vis;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("moocast.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("moocast.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        cows = new Cow[n];
        vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            cows[i] = new Cow(x, y, p);
        }
        int max = 0;
        for (int j = 0; j < n; j++) {
            dfs(j);
            if (count > max) {
                max = count;
            }
            count = 0;
            Arrays.fill(vis, false);
        }
        out.print(max);
        out.close();
    }

    public static void dfs(int s) {
        vis[s] = true;
        ++count;
        for (int i = 0; i < cows.length; i++) {
            double dist = Math.sqrt(Math.pow((cows[i].x - cows[s].x), 2) + Math.pow((cows[i].y - cows[s].y), 2));
            if (!vis[i] && dist <= cows[s].p) {
                dfs(i);
            }
        }
    }
}

class Cow {
    int x;
    int y;
    int p;

    public Cow(int x, int y, int p) {
        this.x = x;
        this.y = y;
        this.p = p;
    }
}
