import java.io.*;
import java.util.*;

public class moobuzz {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("moobuzz.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("moobuzz.out")));
        int n = Integer.parseInt(st.nextToken());
        long lo = 0;
        long hi = (long) 2E9;
        while (lo < hi) {
            long mid = (lo + hi) / 2;
            if (check(mid) >= n) hi = mid; else lo = mid + 1;
        }
        out.print(lo);
        out.close();
        br.close();
    }

    static long check(long n) {
        return n - (n / 3) - (n / 5) + (n / 15);
    }
}
