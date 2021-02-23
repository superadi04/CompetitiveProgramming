import java.io.*;
import java.util.*;

public class blocks {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("blocks.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("blocks.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String first[] = new String[n];
        String second[] = new String[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            first[i] = st.nextToken();
            second[i] = st.nextToken();
        }
        int[] ans = new int[26];
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < n; i++) {
                int firstcount = 0;
                int secondcount = 0;
                for (int j = 0; j < first[i].length(); j++) if (first[i].charAt(j) == c) firstcount++;
                for (int j = 0; j < second[i].length(); j++) if (second[i].charAt(j) == c) secondcount++;
                ans[c - 97] += Math.max(firstcount, secondcount);
            }
        }
        for (int i : ans) {
            out.println(i);
        }
        out.close();
        br.close();
    }

}
