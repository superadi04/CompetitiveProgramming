import java.io.*;
import java.util.StringTokenizer;

public class ccski {
    static int[][] elevations;
    static int[][] waypoints;

    static int waypointCount = 0;
    static int xway = 0;
    static int yway = 0;

    static int m, n;
    static boolean[][] vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("ccski.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ccski.out")));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        elevations = new int[m][n];
        waypoints = new int[m][n];
        vis = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                elevations[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                waypoints[i][j] = Integer.parseInt(st.nextToken());
                if (waypoints[i][j] == 1) {
                    xway = i;
                    yway = j;
                    waypointCount++;
                }
            }
        }

        int min = 0, max = (int) 1E9 + 2;
        while (min <= max) {
            int mid = (min + max) / 2;
            ffcheck(xway, yway, mid);
            if (count < waypointCount) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
            count = 0;
            vis = new boolean[m][n];
        }
        out.println(min);
        out.close();
        br.close();
    }

    static int count = 0;

    static void ffcheck(int r, int c, int d) {
        if (r < 0 || r >= m || c < 0 || c >= n) return;
        if (vis[r][c]) return;
        vis[r][c] = true;
        if (waypoints[r][c] == 1) {
            count++;
        }

        if (r + 1 < m && Math.abs(elevations[r + 1][c] - elevations[r][c]) <= d) {
            ffcheck(r + 1, c, d);
        }
        if (r - 1 >= 0 && Math.abs(elevations[r - 1][c] - elevations[r][c]) <= d) {
            ffcheck(r - 1, c, d);
        }
        if (c + 1 < n && Math.abs(elevations[r][c + 1] - elevations[r][c]) <= d) {
            ffcheck(r, c + 1, d);
        }
        if (c - 1 >= 0 && Math.abs(elevations[r][c - 1] - elevations[r][c]) <= d) {
            ffcheck(r, c - 1, d);
        }

    }
}
