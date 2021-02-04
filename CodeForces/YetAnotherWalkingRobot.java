import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class YetAnotherWalkingRobot {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            HashMap<Pair, Integer> map = new HashMap<>();
            map.put(new Pair(0, 0), 0);
            int currX = 0;
            int currY = 0;
            int start = 0;
            int end = Integer.MAX_VALUE;
            for (int j = 0; j < n;) {
                if (s.charAt(j) == 'U') {
                    currY++;
                } else if (s.charAt(j) == 'D') {
                    currY--;
                } else if (s.charAt(j) == 'R') {
                    currX++;
                } else {
                    currX--;
                }
                Pair p = new Pair(currX, currY);
                j++;
                if (map.containsKey(p) && j - map.get(p) < end - start) {
                    start = map.get(p);
                    end = j;
                    map.put(p, j);
                } else {
                    map.put(p, j);
                }
            }
            System.out.println((end == Integer.MAX_VALUE) ? -1 : (start + 1) + " " + end);
        }
    }

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int hashCode() {
            return x * y + x + y;
        }

        public boolean equals(Object o) {
            Pair p = (Pair) o;
            return x == p.x && y == p.y;
        }
    }
}
