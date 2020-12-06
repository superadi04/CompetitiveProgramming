import java.io.*;
import java.util.*;

public class angry {
    static int n, k;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("angry.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("angry.out")));
        n = Integer.parseInt(st.nextToken()); k = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        out.print(search());
        out.close();
        br.close();
    }

    static int search() {
        int lo = 0, hi = (int) 1E9;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (check(mid)) hi = mid; else lo = mid + 1;
        }
        return lo;
    }

    static boolean check(int r) {
        int count = 1;
        int prev = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] - prev > r * 2) {
                ++count;
                prev = arr[i];
            }
        }
        return count <= k;
    }
}
