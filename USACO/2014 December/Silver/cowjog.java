import java.io.*;
import java.util.*;

public class cowjog {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("cowjog.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjog.out")));
        int n = Integer.parseInt(st.nextToken());
        long t = Long.parseLong(st.nextToken());
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            long pos = Long.parseLong(st.nextToken());
            long speed = Long.parseLong(st.nextToken());
            arr[i] = pos + speed * t;
        }
        int ans = 0;
        long prev = Long.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] < prev) {
                ++ans;
                prev = arr[i];
            }
        }
        out.print(ans);
        out.close();
        br.close();
    }
}
