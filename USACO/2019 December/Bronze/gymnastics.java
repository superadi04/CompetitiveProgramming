import java.io.*;
import java.util.*;

public class gymnastics {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("gymnastics.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gymnastics.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] cows = new int[k][n];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                cows[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int pairs = 0;
        for (int i = 0; i < n - 1; i++) {
            int curr = cows[0][i];
            for (int j = i + 1; j < n; j++) {
                int pair = cows[0][j];
                int count = 0;
                for (int a = 1; a < k; a++) {
                    int index = 0;
                    for (int b = 0; b < n; b++) {
                        if (cows[a][b] == curr) {
                            index = b;
                            break;
                        }
                    }
                    boolean test = false;
                    for (int c = index; c < n; c++) {
                        if (cows[a][c] == pair) {
                            test = true;
                            break;
                        }
                    }
                    if (test) {
                        ++count;
                    }
                }
                if (count == k - 1) {
                    ++pairs;
                }
            }
        }
        out.print(pairs);
        out.close();
    }
}
