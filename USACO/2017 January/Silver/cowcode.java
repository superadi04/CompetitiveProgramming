import java.io.*;
import java.util.*;

public class cowcode {
    static String s;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("cowcode.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowcode.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = st.nextToken();
        long n = Long.parseLong(st.nextToken());
        out.print(solve(n));
        out.close();
        br.close();
    }

    static char solve(long n) {
        if (n <= s.length()) {
            return s.charAt((int) (n - 1));
        }
        long length = s.length();
        while (2 * length < n) {
            length *= 2;
        }
        if (length + 1 != n) {
            return solve(n - (length + 1));
        } else {
            return solve(n - 1);
        }
    }
}
