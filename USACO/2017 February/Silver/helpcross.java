import java.io.*;
import java.util.*;

public class helpcross {
    static TreeMap<Integer, Integer> chickens = new TreeMap<Integer, Integer>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("helpcross.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("helpcross.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < c; i++) {
            st = new StringTokenizer(br.readLine());
            add(Integer.parseInt(st.nextToken()));
        }
        Cow[] cows = new Cow[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            cows[i] = new Cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(cows);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            try {
                int currChicken = chickens.ceilingKey(cows[i].start);
                if (currChicken <= cows[i].end) {
                    ++ans;
                    remove(currChicken);
                }
            } catch (Exception e) {
                continue;
            }

        }
        out.print(ans);
        out.close();
        br.close();
    }

    static void add(int x) {
        if (chickens.containsKey(x)) {
            chickens.put(x, chickens.get(x) + 1);
        } else {
            chickens.put(x, 1);
        }
    }

    static void remove(int x) {
        chickens.put(x, chickens.get(x) - 1);
        if (chickens.get(x) == 0) {
            chickens.remove(x);
        }
    }

    static class Cow implements Comparable<Cow>{
        int start;
        int end;

        public Cow(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Cow o) {
            return Integer.compare(end, o.end);
        }
    }
}
