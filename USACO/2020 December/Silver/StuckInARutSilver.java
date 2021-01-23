import java.io.*;
import java.util.*;

public class StuckInARutSilver {
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
                north.add(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i));
            } else {
                east.add(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i));
            }
        }

        Collections.sort(north, Comparator.comparingInt(p -> (int) p.f));
        Collections.sort(east, Comparator.comparingInt(p -> (int) p.s));

        int[] answers = new int[n];
        HashSet<Integer> stopped = new HashSet<>();

        for (Pair a : north) {
            for (Pair b : east) {
                if (((int) a.f > (int) b.f && (int) a.s < (int) b.s) && !stopped.contains(a.index) && !stopped.contains(b.index)) {
                    if (Math.abs((int) a.s - (int) b.s) < Math.abs((int) a.f - (int) b.f)) {
                        answers[a.index] += answers[b.index] + 1;
                        stopped.add(b.index);
                    } else if (Math.abs((int) a.s - (int) b.s) > Math.abs((int) a.f - (int) b.f)) {
                        answers[b.index] += answers[a.index] + 1;
                        stopped.add(a.index);
                    }
                }
            }
        }

        for (int i : answers) {
            System.out.println(i);
        }

    }

    public static class Pair<K, V> {
        K f;
        V s;
        int index;

        public Pair(K first, V second, int index) {
            this.f = first;
            this.s = second;
            this.index = index;
        }
    }
}