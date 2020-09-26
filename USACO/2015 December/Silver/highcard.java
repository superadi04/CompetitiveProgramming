import java.io.*;
import java.util.*;

public class highcard {
    static TreeSet<Integer> set = new TreeSet<Integer>();
    static HashSet<Integer> set2 = new HashSet<Integer>();
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("highcard.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("highcard.out")));
        int n = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            set2.add(Integer.parseInt(st.nextToken()));
        }
        for (int i = 1; i <= n * 2; i++) {
            if (!set2.contains(i)) {
                set.add(i);
            }
        }
        int count = 0;
        for (int i : set2) {
            try {
                int a = set.higher(i);
                ++count;
                set.remove(a);
            } catch (Exception e) {
                continue;
            }
        }
        out.print(count);
        out.close();
        br.close();
    }
}
