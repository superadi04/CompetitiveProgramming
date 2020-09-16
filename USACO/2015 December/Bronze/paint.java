import java.io.*;
import java.util.*;

public class paint {
    static boolean[] fence = new boolean[100];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("paint.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("paint.out")));
        int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken()), d = Integer.parseInt(st.nextToken());
        for (int i = a; i < b; i++) {
            fence[i] = true;
        }
        for (int i = c; i < d; i++) {
            fence[i] = true;
        }
        int count = 0;
        for (boolean i : fence) {
            if (i) {
                ++count;
            }
        }
        out.print(count);
        out.close();
        br.close();
    }
}
