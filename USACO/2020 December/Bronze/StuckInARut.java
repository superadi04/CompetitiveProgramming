import java.io.*;
import java.util.*;

public class StuckInARut {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        // Arraylist containing cows facing in north or east
        ArrayList<Pair> north = new ArrayList<>();
        ArrayList<Pair> east = new ArrayList<>();

        // Input cows
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            char dir = st.nextToken().charAt(0);
            if (dir == 'N') {
                north.add(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
                north.get(north.size() - 1).index = i;
                north.get(north.size() - 1).dir = 'N';
            } else {
                east.add(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
                east.get(east.size() - 1).index = i;
                east.get(east.size() - 1).dir = 'E';
            }
        }

        ArrayList<Pair> intersections = new ArrayList<>();

        for (Pair i : north) {
            for (Pair j : east) {
                if ((int) i.f > (int) j.f && (int) j.s > (int) i.s) {
                    int d1 = (int) i.f - (int) j.f;
                    int d2 = (int) j.s - (int) i.s;
                    if (d1 > d2) {
                        // First element contains the cow that is stopped, the second contains the cow that leaves the rut
                        intersections.add(new Pair(j, i));
                        intersections.get(intersections.size() - 1).index = d1;
                    } else if (d2 > d1) {
                        intersections.add(new Pair(i, j));
                        intersections.get(intersections.size() - 1).index = d2;
                    }
                }
            }
        }

        Collections.sort(intersections);
        HashMap<Pair, Pair> stopped = new HashMap<Pair, Pair>();
        int[] answers = new int[n];
        Arrays.fill(answers, Integer.MAX_VALUE);
        for (Pair p : intersections) {
            if (!stopped.containsKey(p.f)) {
                if (stopped.containsKey(p.s)) {
                    // Check if the cell that the cow is in already has a rut if the cow that stopped it has already stoppped
                    Pair curr = (Pair) p.f; // The cow that is stopped
                    Pair stop = stopped.get(p.s); // The cow that is "continuing"
                    if (curr.dir == 'N' && (int) curr.f <= (int) stop.f) {
                        answers[curr.index] = Math.min(answers[curr.index], p.index);
                        stopped.put(curr, new Pair(curr.f, (int) curr.s + p.index));
                    } else if (curr.dir == 'E' && (int) curr.s <= (int) stop.s){
                        answers[curr.index] = Math.min(answers[curr.index], p.index);
                        stopped.put(curr, new Pair((int) curr.f + p.index, curr.s));
                    }
                } else {
                    Pair curr = (Pair) p.f;
                    answers[curr.index] = Math.min(answers[curr.index], p.index);
                    if (curr.dir == 'N') {
                        stopped.put(curr, new Pair(curr.f, (int) curr.s + p.index));
                    } else {
                        stopped.put(curr, new Pair((int) curr.f + p.index, curr.s));
                    }
                }
            }
        }

        for (int i : answers) {
            System.out.println(i == Integer.MAX_VALUE ? "Infinity" : i);
        }
    }

    public static class Pair<K, V> implements Comparable<Pair> {
        K f;
        V s;
        int index;
        char dir;

        public Pair(K first, V second) {
            this.f = first;
            this.s = second;
        }

        public int compareTo(Pair o) {
            return Integer.compare(index, o.index);
        }

        @Override
        public boolean equals(Object o) {
            Pair p = (Pair) o;
            return f.equals(p.f)  && s.equals(p.s);
        }

        @Override
        public int hashCode() {
            return index * dir;
        }
    }
}
