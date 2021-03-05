import java.io.*;
import java.util.StringTokenizer;

public class taming {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("taming.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] log = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            log[i] = Integer.parseInt(st.nextToken());
        }
        boolean[] started = new boolean[n];
        started[0] = true;
        int min = 1;
        for (int i = 0; i < n; i++) {
            if (log[i] != -1 && i - log[i] >= 0) {
                if (!started[i - log[i]]) min++;
                started[i - log[i]] = true;
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (started[i]) {
                int init = i;
                int last = 0;
                while (i + 1 < n && !started[i + 1]) {
                    last = Math.max(last, log[++i]);
                }
                max += i - init - last + 1;
            }
        }
        boolean test = false;
        int curr = 0;
        for (int i = 1; i < n; i++) {
            curr++;
            if (started[i]) curr = 0;
            if (log[i] > -1 && log[i] != curr) test = true;
        }
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("taming.out")));
        out.println((test) ? -1 : min +  " " + max);
        out.close();
    }
}
