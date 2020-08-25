import java.io.*;
import java.util.*;

public class lemonade {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("lemonade.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lemonade.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] cows = new int[n];
        for (int i = 0; i < n; i++) {
            cows[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cows);
        int count = 0;
        for (int i = n - 1; i >= 0; --i) {
            if (count > cows[i]) {
                break;
            }
            ++count;
        }
        out.print(count);
        out.close();
    }
}
