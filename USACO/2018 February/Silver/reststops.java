import java.io.*;
import java.util.*;

public class reststops {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("reststops.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("reststops.out")));
        long l = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        long rf = Integer.parseInt(st.nextToken());
        long rb = Integer.parseInt(st.nextToken());
        Stop[] arr = new Stop[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Stop(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(arr);
        long currpos = 0;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i].pos > currpos) {
                ans += ((arr[i].pos - currpos) * (rf - rb) * arr[i].taste);
                currpos = arr[i].pos;
            }
        }
        out.print(ans);
        out.close();
        br.close();
    }

    static class Stop implements Comparable<Stop> {
        long pos;
        long taste;

        public Stop(int pos, int taste) {
            this.pos = pos;
            this.taste = taste;
        }

        @Override
        public int compareTo(Stop o) {
            // Sort by taste, not position. This is a classic greedy problem.
            return Long.compare(o.taste, taste);
        }
    }
}
