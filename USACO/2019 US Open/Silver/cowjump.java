import java.io.*;
import java.util.*;

public class cowjump {
    static Pair[] points;
    static TreeSet<Pair> active;
    static HashSet<Integer>[] intersecting;
    static Pair[][] segments;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("cowjump.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        points = new Pair[n * 2];
        segments = new Pair[n][2];
        for (int i = 0; i < n * 2; i += 2) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            points[i] = new Pair(x1, y1, i / 2);
            points[i + 1] = new Pair(x2, y2, i / 2);
            segments[i / 2][0] = points[i];
            segments[i / 2][1] = points[i + 1];
        }
        Arrays.sort(points, Comparator.comparingInt(p -> p.f));
        active = new TreeSet<>(
                (o1, o2) -> {
                    if (o1.s == o2.s) {
                        return Integer.compare(o1.f, o2.f);
                    }
                    return Integer.compare(o1.s, o2.s);
                }
        );
        intersecting = new HashSet[n];
        for (int i = 0; i < n; i++) {
            intersecting[i] = new HashSet<>();
        }
        for (Pair p : points) {
            if (!active.contains(p)) {
                checkLine(segments[p.index][0], segments[p.index][1]);
                active.add(segments[p.index][0]);
                active.add(segments[p.index][1]);
            } else {
                active.remove(segments[p.index][0]);
                active.remove(segments[p.index][1]);
                checkLine(segments[p.index][0], segments[p.index][1]);
            }
        }
        int ans = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (intersecting[i].size() > max) {
                max = intersecting[i].size();
                ans = i;
            }
        }
        out.println(ans + 1);
        out.close();
        br.close();
    }

    public static void checkLine(Pair p1, Pair p2) {
        if (p1.s > p2.s) {
            // Swap such that p2 has the highest y value
            Pair swap = p1;
            p1 = p2;
            p2 = swap;
        }
        if (!active.isEmpty()) {
            // First we check the points above the lowest point
            if (active.last().s >= p1.s && !active.ceiling(p1).equals(p2)) {
                Pair higher = active.ceiling(p1);
                if (intersectQ(p1, p2, segments[higher.index][0], segments[higher.index][1])) {
                    intersecting[p1.index].add(higher.index);
                    intersecting[higher.index].add(p1.index);
                }
            }
            // Next we check the points lower the higher point
            if (active.first().s <= p2.s && !active.floor(p2).equals(p1)) {
                Pair lower = active.floor(p2);
                if (intersectQ(p1, p2, segments[lower.index][0], segments[lower.index][1])) {
                    intersecting[p1.index].add(lower.index);
                    intersecting[lower.index].add(p1.index);
                }
            }
        }
    }

    public static int sign(Pair A, Pair B, Pair C) {
        int area = (B.f-A.f) * (C.s-A.s) - (C.f-A.f) * (B.s-A.s);
        if (area > 0) return 1;
        if (area < 0) return -1;
        return 0;
    }

    public static boolean between(Pair P, Pair X, Pair Y) {
        return ((X.f <= P.f && P.f <= Y.f) || (Y.f <= P.f && P.f <= X.f))
                && ((X.s <= P.s && P.s <= Y.s) || (Y.s <= P.s && P.s <= X.s));
    }

    public static boolean intersectQ(Pair P, Pair Q, Pair X, Pair Y) {
        int[] signs = {sign(P, X, Y), sign(Q, X, Y), sign(X, P, Q), sign(Y, P, Q)};
        if (signs[0] == 0 && signs[1] == 0 && signs[2] == 0 && signs[3] == 0)
            return between(P, X, Y) || between(Q, X, Y) || between(X, P, Q);
        return signs[0] != signs[1] && signs[2] != signs[3];
    }

    static class Pair {
        int f;
        int s;
        int index;

        public Pair(int f, int s, int index) {
            this.f = f;
            this.s = s;
            this.index = index;
        }

        public int hashCode() {
            return f * s;
        }

        public boolean equals(Object o) {
            Pair p = (Pair) o;
            return p.f == f && p.s == s;
        }
    }
}