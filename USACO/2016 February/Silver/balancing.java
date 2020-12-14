import java.io.*;
import java.util.*;

public class balancing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("balancing.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("balancing.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        Pairx[] pointsx = new Pairx[n];
        Pairy[] pointsy = new Pairy[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pointsx[i] = new Pairx(x, y);
            pointsy[i] = new Pairy(x, y);
        }
        int ans = Integer.MAX_VALUE;
        Arrays.sort(pointsx);
        Arrays.sort(pointsy);

        for (int i = 0; i < n; i++) {
            int vline = pointsx[i].x;
            int q1 = 0, q2 = 0, q3 = 0, q4 = 0;
            for (int j = 0; j < n; j++) {
                if (pointsy[j].x > vline) {
                    q1++;
                } else {
                    q2++;
                }
            }
            ans = Math.min(ans, max(q1, q2, q3, q4));
            for (int j = 0; j < n - 1; j++) {
                if (pointsy[j].x > vline) {
                    q1--;
                    q4++;
                } else {
                    q2--;
                    q3++;
                }
                ans = Math.min(ans, max(q1, q2, q3, q4));
            }
        }
        out.println(ans);
        out.close();
        br.close();
    }

    static int max(int a, int b, int c, int d) {
        return Math.max(a, Math.max(b, Math.max(c, d)));
    }

    static class Pairy implements Comparable<Pairy> {
        int x;
        int y;

        public Pairy(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int compareTo(Pairy p) {
            return Integer.compare(y, p.y);
        }
    }

    static class Pairx implements Comparable<Pairx> {
        int x;
        int y;

        public Pairx(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pairx p) {
            return Integer.compare(x, p.x);
        }
    }
}
