import java.io.*;
import java.util.*;

public class photo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("photo.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("photo.out")));
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Pair[] arr = new Pair[k];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i] = new Pair(Math.min(a, b), Math.max(a, b));
        }
        Arrays.sort(arr);
        TreeSet<Integer> set = new TreeSet<Integer>();
        set.add(arr[0].b - 1);
        for (Pair p : arr) {
            if (set.lower(p.b) < p.a) {
                set.add(p.b - 1);
            }
        }
        out.print(set.size() + 1);
        out.close();
        br.close();
    }

    static class Pair implements Comparable<Pair> {
        int a;
        int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(b, o.b);
        }
    }
}
