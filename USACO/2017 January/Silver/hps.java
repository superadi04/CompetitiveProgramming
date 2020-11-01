import java.io.*;
import java.util.*;

public class hps {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("hps.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hps.out")));
        int n = Integer.parseInt(st.nextToken());
        int[] hoof = new int[n + 1];
        int[] paper = new int[n + 1];
        int[] scissors = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            if (c == 'H') ++hoof[i];
            else if (c == 'P') ++paper[i];
            else ++scissors[i];
            hoof[i] += hoof[i - 1]; paper[i] += paper[i - 1]; scissors[i] += scissors[i - 1];
        }
        int ans = 0;
        for (int i = 1; i < n + 1; i++) {
            ans = Math.max(ans, hoof[i] - hoof[0] + paper[n] - paper[i]);
            ans = Math.max(ans, hoof[i] - hoof[0] + scissors[n] - scissors[i]);
            ans = Math.max(ans, paper[i] - paper[0] + hoof[n] - hoof[i]);
            ans = Math.max(ans, paper[i] - paper[0] + scissors[n] - scissors[i]);
            ans = Math.max(ans, scissors[i] - scissors[0] + hoof[n] - hoof[i]);
            ans = Math.max(ans, scissors[i] - scissors[0] + paper[n] - paper[i]);
        }
        out.print(ans);
        out.close();
        br.close();
    }
}
