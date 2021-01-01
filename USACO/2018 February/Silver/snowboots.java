import java.io.*;
import java.util.*;

public class snowboots {
    static int[] tiles; // Stores depth of each tile
    static Pair[] boots; // Stores boots (depth + step size)
    static int ans = Integer.MAX_VALUE; // Our answer
    static boolean[][] vis; // To check if we have been in the same state

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("snowboots.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("snowboots.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n, b;
        n = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        tiles = new int[n];
        boots = new Pair[b];
        vis = new boolean[n][b];

        st = new StringTokenizer(br.readLine());
        // Input tile depths
        for (int i = 0; i < n; i++) {
            tiles[i] = Integer.parseInt(st.nextToken());
        }

        // Input boots (depth + step size)
        for (int i = 0; i < b; i++) {
            st = new StringTokenizer(br.readLine());
            boots[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        dfs(0, 0);

        // Output our answer.
        out.println(ans);
        out.close();
        br.close();
    }

    static void dfs(int tilesIndex, int bootsIndex) {
        // Have we reached the end?
        if (tilesIndex >= tiles.length - 1) {
            ans = Math.min(ans, bootsIndex);
            return;
        }

        // Have we been in this state before?
        if (vis[tilesIndex][bootsIndex]) return;
        vis[tilesIndex][bootsIndex] = true;

        // Is our boot size too small?
        if (boots[bootsIndex].a < tiles[tilesIndex]) return;

        // Recurse through all possible combinations of boots + step sizes
        for (int i = bootsIndex; i < boots.length; i++) {
            for (int j = 0; j <= boots[i].b; j++) {
                if (tiles[tilesIndex] <= boots[i].a) {
                    dfs(tilesIndex + j, i);
                }
            }
        }
    }

    static class Pair {
        int a, b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
