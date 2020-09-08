import java.io.*;
import java.util.*;

public class WhereAmI {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("whereami.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("whereami.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        int max = 1;
        for (int i = 0; i < n - max + 1; i++) {
            String test = s.substring(i, max + i);
            boolean b = false;
            for (int j = 0; j < n - max + 1; j++) {
                if (i == j) {
                    continue;
                }
                if (s.substring(j, max + j).equals(test)) {
                    b = true;
                    break;
                }
            }
            if (b) {
                i = 0;
                ++max;
            }
        }
        out.println(max);
        out.close();
        br.close();
    }
}
