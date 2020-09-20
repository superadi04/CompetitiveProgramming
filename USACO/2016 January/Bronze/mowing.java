import java.io.*;
import java.util.StringTokenizer;

public class mowing {
    static int[][] grid = new int[2000][2000];
    static int time = 0;
    static int x = 1000;
    static int y = 1000;
    static int maxTime = 1000;
    static boolean test = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("mowing.in"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mowing.out")));
        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < 2000; i++) {
            for (int j = 0; j < 2000; j++) {
                grid[i][j] = -1;
            }
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            int dist = Integer.parseInt(st.nextToken());
            if (c == 'N') {
                for (int j = y; j < y + dist; j++) {
                    ++time;
                    if (grid[x][j] != -1) {
                        maxTime = Math.min(maxTime, time - grid[x][j]);
                        test = true;
                    }
                    grid[x][j] = time;
                }
                y += dist;
            } else if (c == 'S') {
                for (int j = y; j > y - dist; j--) {
                    ++time;
                    if (grid[x][j] != -1) {
                        maxTime = Math.min(maxTime, time - grid[x][j]);
                        test = true;
                    }
                    grid[x][j] = time;
                }
                y -= dist;
            } else if (c == 'E') {
                for (int j = x; j < x + dist; j++) {
                    ++time;
                    if (grid[j][y] != -1) {
                        maxTime = Math.min(maxTime, time - grid[j][y]);
                        test = true;
                    }
                    grid[j][y] = time;
                }
                x += dist;
            } else if (c == 'W'){
                for (int j = x; j > x - dist; j--) {
                    ++time;
                    if (grid[j][y] != -1) {
                        maxTime = Math.min(maxTime, time - grid[j][y]);
                        test = true;
                    }
                    grid[j][y] = time;
                }
                x -= dist;
            }
        }
        out.print(test ? maxTime : -1);
        out.close();
        br.close();
    }
}

class mow {
    boolean mowed;
    int time;
    
    public mow(boolean mowed) {
        this.mowed = mowed;
    }
}
