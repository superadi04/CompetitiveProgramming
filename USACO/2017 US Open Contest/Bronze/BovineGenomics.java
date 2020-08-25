import java.io.*;
import java.util.*;

public class BovineGenomics {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("cownomics.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cownomics.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] spotted = new char[n][m];
        char[][] plain = new char[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                spotted[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                plain[i][j] = s.charAt(j);
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            boolean test = true;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (spotted[j][i] == plain[k][i]) {
                        test = false;
                    }
                }
            }
            if (test) {
                count++;
            }
        }
        out.println(count);
        out.close();
    }
}
