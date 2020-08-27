import java.io.*;
import java.util.*;

public class mountains {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("mountains.in"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mountains.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[] x = new int[n];
        int[] y = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] check = new boolean[n];
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            if (check[i]) {
                continue;
            }
            int x1 = x[i], y1 = y[i];
            for (int j = i + 1; j < n; j++) {
                if (check[j]) {
                    continue;
                }
                int x2 = x[j], y2 = y[j];
                if (compare(x1, x2, y1, y2) >= 0) {
                    if (y1 < y2) {
                        check[i] = true;
                    } else {
                        check[j] = true;
                    }
                }
            }
        }

        for (boolean b : check) {
            if (!b) {
                count++;
            }
        }

        out.print(count);
        out.close();
    }

    public static int compare(int x1, int x2, int y1, int y2) {
        if (x2 - x1 == 0) {
            return 0;
        }
        return Integer.compare(Math.abs((y2 - y1)/(x2 - x1)), 1);
    }
}


