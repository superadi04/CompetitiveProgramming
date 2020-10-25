import java.io.*;
import java.util.*;

public class socdist {
    static int n, m;
    static long[] arr;
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("socdist.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("socdist.out")));
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        arr = new long[m * 2];
        for (int i = 0; i < m * 2; i += 2) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Long.parseLong(st.nextToken());
            arr[i + 1] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        out.print(search());
        out.close();
        br.close();
    }

    static long search() {
        long lo = 0, hi = (long) 1E18;
        long res = lo;
        while (lo <= hi) {
            long mid = (lo + hi) / 2;
            if (check(mid)) {
                hi = mid - 1;
            } else {
                res = mid;
                lo = mid + 1;
            }
        }
        return res;
    }

    static boolean check(long d) {
        int ans = 0;
        long last = 0;
        for (int i = 0; i < m * 2; i += 2) {
            long dif;
            if (last <= arr[i]) {
                dif = arr[i + 1] - arr[i];
            } else if (last > arr[i] && last <= arr[i + 1]) {
                dif = arr[i + 1] - last;
            } else {
                continue;
            }
            ans += dif / d + 1;
            last = arr[i + 1] + ((dif % d == 0) ? d : d - (dif % d));
        }
        return ans < n;
    }
}
