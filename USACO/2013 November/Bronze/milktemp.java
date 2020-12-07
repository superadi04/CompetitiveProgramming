import java.io.*;
import java.util.*;

public class milktemp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("milktemp.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milktemp.out")));
        int n, x, y, z;
        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        z = Integer.parseInt(st.nextToken());
        Pair[] arr = new Pair[n * 2];
        for (int i = 0; i < n * 2; i+=2) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Pair(Integer.parseInt(st.nextToken()), i, true);
            arr[i + 1] = new Pair(Integer.parseInt(st.nextToken()), i, false);
        }
        Arrays.sort(arr);
        int ans = Math.max(x * n, z * n);
        HashSet<Integer> leaving = new HashSet<Integer>();
        int passed = 0;
        for (Pair p : arr) {
            if (leaving.contains(p.b)) {
                leaving.remove(p.b);
                passed++;
            } else {
                leaving.add(p.b);
            }
            ans = Math.max(ans, y * leaving.size() + z * passed + x * (n - leaving.size() - passed));
        }
        out.print(ans);
        out.close();
        br.close();
    }

    static class Pair implements Comparable<Pair>{
        int a;
        int b;
        boolean test;

        public Pair(int a, int b, boolean test) {
            this.a = a;
            this.b = b;
            this.test = test;
        }

        @Override
        public int compareTo(Pair o) {
            if (a == o.a) {
                return (test) ? -1 : 1;
            }
            return Integer.compare(a, o.a);
        }
    }
}