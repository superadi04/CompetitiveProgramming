import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] matrix = new int[n][n];
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            HashSet<Integer>[] rows = new HashSet[n];
            HashSet<Integer>[] columns = new HashSet[n];

            for (int j = 0; j < n; j++) {
                rows[j] = new HashSet<>();
                columns[j] = new HashSet<>();
            }

            int trace = 0;
            for (int j = 0; j < n; j++) {
                trace += matrix[j][j];
                for (int k = 0; k < n; k++) {
                    rows[j].add(matrix[j][k]);
                    columns[j].add(matrix[k][j]);
                }
            }

            int r = 0, c = 0;
            for (int j = 0; j < n; j++) {
                if (rows[j].size() < n) r++;
                if (columns[j].size() < n) c++;
            }

            System.out.println("Case #" + i + ": " + trace + " " + r + " " + c);
        }
    }
}
