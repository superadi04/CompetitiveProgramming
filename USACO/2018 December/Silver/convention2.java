import java.io.*;
import java.util.*;

public class convention2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("convention2.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("convention2.out")));
        int n = Integer.parseInt(st.nextToken());
        PriorityQueue<Cow> cows = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            cows.add(new Cow(start, time, i));
        }
        int ans = 0;
        TreeMap<Integer, Cow> waiting = new TreeMap<>();
        Cow sampling = cows.poll();
        int currTime = sampling.start + sampling.time;
        while (!cows.isEmpty()) {
            Cow c = cows.peek();
            if (c.start < currTime) {
                waiting.put(c.seniority, c);
                cows.poll();
            } else {
                if (waiting.size() > 0 && (currTime < c.start || (currTime == c.start && waiting.firstKey() < c.seniority))) {
                    ans = Math.max(ans, currTime - waiting.get(waiting.firstKey()).start);
                    sampling = waiting.get(waiting.firstKey());
                    currTime += sampling.time;
                    waiting.remove(waiting.firstKey());
                } else {
                    sampling = cows.poll();
                    currTime = sampling.start + sampling.time;
                }
            }
        }
        while (waiting.size() > 0) {
            ans = Math.max(ans, currTime - waiting.get(waiting.firstKey()).start);
            sampling = waiting.get(waiting.firstKey());
            currTime += sampling.time;
            waiting.remove(waiting.firstKey());
        }
        out.print(ans);
        out.close();
        br.close();
    }

    static class Cow implements Comparable<Cow> {
        int start;
        int time;
        int seniority;

        public Cow(int start, int end, int seniority) {
            this.start = start;
            time = end;
            this.seniority = seniority;
        }

        @Override
        public int compareTo(Cow o) {
            return Integer.compare(start, o.start);
        }
    }
}