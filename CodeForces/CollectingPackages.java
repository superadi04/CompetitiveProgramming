import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CollectingPackages {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        outer: for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            Pair[] points = new Pair[n + 1];
            for (int j = 1; j <= n; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                points[j] = new Pair(x, y);
            }
            points[0] = new Pair(0, 0);
            String ans = "";
            Arrays.sort(points);
            for (int j = 0; j < n; j++) {
                if (points[j].y > points[j + 1].y) {
                    System.out.println("NO");
                    continue outer;
                }
                for (int k = points[j].x; k < points[j + 1].x; k++) {
                    ans += "R";
                }
                for (int k = points[j].y; k < points[j + 1].y; k++) {
                    ans += "U";
                }
            }
            System.out.println("YES\n" + ans);
        }
    }

    static class Pair implements Comparable<Pair> {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int compareTo(Pair o) {
            if (x == o.x) return Integer.compare(y, o.y);
            return Integer.compare(x, o.x);
        }
    }
}
