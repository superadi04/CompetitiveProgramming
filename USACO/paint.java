import java.io.*;
import java.util.*;

public class paint {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("paint.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("paint.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int currPos = 0;
        ArrayList<Pair> positions = new ArrayList<>();
        int n, k;
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int move = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);

            if (dir == 'R') {
                positions.add(new Pair(currPos, true));
                currPos += move;
                positions.add(new Pair(currPos, false));
            } else {
                positions.add(new Pair(currPos, false));
                currPos -= move;
                positions.add(new Pair(currPos, true));
            }
        }
        Collections.sort(positions);
        int ans = 0;
        int prev = positions.get(0).pos;
        int pref = 1;
        boolean ink = false;
        for (int i = 1; i < positions.size(); i++) {
            if (positions.get(i).add) {
                pref++;
            } else {
                pref--;
            }

            if (pref == k && !ink) {
                prev = positions.get(i).pos;
                ink = true;
            } else if (ink && pref < k) {
                ans += (positions.get(i).pos - prev);
                ink = false;
            }
        }
        out.println(ans);
        out.close();
        br.close();
    }

    static class Pair implements Comparable<Pair>{
        int pos;
        boolean add;

        public Pair(int pos, boolean add) {
            this.pos = pos;
            this.add = add;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(pos, o.pos);
        }
    }
}
