import java.io.*;
import java.util.*;

public class bcount {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("bcount.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("bcount.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int[][] cows = new int[n + 1][3];
        st = new StringTokenizer(br.readLine());
        int id = Integer.parseInt(st.nextToken());
        ++cows[1][id - 1];
        for (int i = 2; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            id = Integer.parseInt(st.nextToken());
            cows[i][0] += cows[i - 1][0];
            cows[i][1] += cows[i - 1][1];
            cows[i][2] += cows[i - 1][2];
            ++cows[i][id - 1];
        }
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            out.println((cows[b][0] - cows[a - 1][0]) + " " + (cows[b][1] - cows[a - 1][1]) + " " + (cows[b][2] - cows[a - 1][2]));
        }
        out.close();
        br.close();
    }
}
