import java.io.*;
import java.util.*;

public class cbarn {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("cbarn.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cbarn.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] barn = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            barn[i] = Integer.parseInt(st.nextToken());
        }

        int[] distances = new int[n];
        int check = 0;
        int i = 0;
        while (check < n) {
            int count = 0;
            int origDist = distances[i % n];
            int orig = i;
            if (barn[i % n] == 1) {
                check++;
            } else {
                check = 0;
            }
            boolean test = false;
            while (barn[i % n] > 0 && barn[(i + 1) % n] == 0) {
                barn[i % n]--;
                barn[(i + 1) % n]++;
                count++;
                i++;
                test = true;
            }
            if (test || barn[i % n] != 1) {
                check = 0;
            } else if (orig != i) {
                check++;
            }
            distances[i % n] = origDist + count;
            i++;
        }

        int ans = 0;
        for (int x : distances) {
            ans += x * x;
        }

        out.println(ans);
        out.close();
        br.close();
    }
}
