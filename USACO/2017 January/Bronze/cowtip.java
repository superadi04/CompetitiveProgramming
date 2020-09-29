import java.io.*;
import java.util.*;

public class cowtip {
    static int grid[][];
    static int count = 0;
    static int x = -1;
    static int y = -1;
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("cowtip.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowtip.out")));
        int n = Integer.parseInt(st.nextToken());
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(s.substring(j, j + 1));
            }
        }
        getMax(n);
        while (x != -1) {
            ++count;
            flip();
            x = -1;
            y = -1;
            getMax(n);
        }
        out.print(count);
        out.close();
        br.close();
    }

    public static void getMax(int n) {
        int maxDist = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                if (grid[i][j] == 1 && maxDist <= Math.sqrt(i * i + j * j)) {
                    maxDist = (int) Math.sqrt(i * i + j * j);
                    x = j;
                    y = i;
                }
            }
            for (int j = 0; j <= i; j++) {
                if (grid[j][i] == 1 && maxDist <= Math.sqrt(i * i + j * j)) {
                    maxDist = (int) Math.sqrt(i * i + j * j);
                    x = i;
                    y = j;
                }
            }
            if (x != -1) {
                return;
            }
        }
    }

    public static void flip() {
        for (int i = 0; i <= y; i++) {
            for (int j = 0; j <= x; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                } else {
                    grid[i][j] = 1;
                }
            }
        }
    }
}
