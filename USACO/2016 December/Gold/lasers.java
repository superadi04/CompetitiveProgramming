import java.io.*;
import java.util.*;

public class lasers {
    static int n;
    static int xl;
    static int yl;
    static int xb;
    static int yb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("lasers.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lasers.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        xl = Integer.parseInt(st.nextToken());
        yl = Integer.parseInt(st.nextToken());
        xb = Integer.parseInt(st.nextToken());
        yb = Integer.parseInt(st.nextToken());

        int[] xcoor = new int[n];
        int[] ycoor = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            xcoor[i] = Integer.parseInt(st.nextToken());
            ycoor[i] = Integer.parseInt(st.nextToken());
        }

        TreeSet<Integer> points = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            points.add(xcoor[i]);
            points.add(ycoor[i]);
        }

        points.add(xl);
        points.add(xb);
        points.add(yl);
        points.add(yb);

        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i : points) {
            map.put(i, count++);
        }

        for (int i = 0; i < n; i++) {
            xcoor[i] = map.get(xcoor[i]);
            ycoor[i] = map.get(ycoor[i]);
        }

        xl = map.get(xl);
        yl = map.get(yl);
        xb = map.get(xb);
        yb = map.get(yb);

        TreeSet<Integer>[] xline = new TreeSet[n * 2 + 4];
        TreeSet<Integer>[] yline = new TreeSet[n * 2 + 4];

        for (int i = 0; i < n * 2 + 4; i++) {
            xline[i] = new TreeSet<>();
            yline[i] = new TreeSet<>();
        }

        for (int i = 0; i < n; i++) {
            xline[xcoor[i]].add(ycoor[i]);
            yline[ycoor[i]].add(xcoor[i]);
        }

        xline[xl].add(yl);
        xline[xb].add(yb);
        yline[yl].add(xl);
        yline[yb].add(xb);

        int ans = -1;

        Queue<Pair> q = new LinkedList<>();

        // The direction is 0 if laser is traveling horizontally
        // and 1 if the laser is traveling vertically
        q.add(new Pair(xl, yl, 0, 1));
        q.add(new Pair(xl, yl, 0, 0));

        HashSet<Pair> visited = new HashSet<>();

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            if (curr.x == xb && curr.y == yb && (ans == -1 || ans > curr.dist)) {
                ans = curr.dist;
                continue;
            }
            if (visited.contains(curr)) {
                continue;
            }
            visited.add(curr);
            if (xline[curr.x].last() > curr.y && curr.dir == 1) {
                q.add(new Pair(curr.x, xline[curr.x].higher(curr.y), curr.dist + 1, 0));
                q.add(new Pair(curr.x, xline[curr.x].higher(curr.y), curr.dist, 1));
            }
            if (xline[curr.x].first() < curr.y && curr.dir == 1) {
                q.add(new Pair(curr.x, xline[curr.x].lower(curr.y), curr.dist + 1, 0));
                q.add(new Pair(curr.x, xline[curr.x].lower(curr.y), curr.dist, 1));
            }
            if (yline[curr.y].last() > curr.x && curr.dir == 0) {
                q.add(new Pair(yline[curr.y].higher(curr.x), curr.y, curr.dist + 1, 1));
                q.add(new Pair(yline[curr.y].higher(curr.x), curr.y, curr.dist, 0));
            }
            if (yline[curr.y].first() < curr.x && curr.dir == 0) {
                q.add(new Pair(yline[curr.y].lower(curr.x), curr.y, curr.dist + 1, 1));
                q.add(new Pair(yline[curr.y].lower(curr.x), curr.y, curr.dist, 0));
            }
        }

        out.println(ans);
        out.close();
        br.close();
    }

    static class Pair {
        int x, y, dist, dir;

        public Pair(int x, int y, int dist, int dir) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.dir = dir;
        }

        public int hashCode() {
            return x * y;
        }

        public boolean equals(Object o) {
            Pair p = (Pair) o;
            return x == p.x && y == p.y && dir == p.dir;
        }

    }
}
