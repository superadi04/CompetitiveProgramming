import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long[] v1 = new long[n];
            long[] v2 = new long[n];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) v1[j] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) v2[j] = Integer.parseInt(st.nextToken());
            Arrays.sort(v1);
            Arrays.sort(v2);
            long sum = 0;
            for (int j = 0; j < n; j++) {
                sum += (v1[j] * v2[n - j - 1]);
            }
            System.out.println("Case #" + i + ": " + sum);
        }
    }
}