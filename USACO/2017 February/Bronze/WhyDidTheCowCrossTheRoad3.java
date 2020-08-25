
import java.io.*;
import java.util.*;

public class WhyDidTheCowCrossTheRoad3 {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("cowqueue.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowqueue.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int arrival = Integer.parseInt(st.nextToken());
            int questioning = Integer.parseInt(st.nextToken());
            if (map.containsKey(arrival)) {
                map.put(arrival, map.get(arrival) + questioning);
            } else {
                map.put(arrival, questioning);
            }
        }

        int count = map.firstKey() + map.get(map.firstKey());
        map.remove(map.firstKey());
        int size = map.size();
        for (int i = 0; i < size; i++) {
            if (count < map.firstKey()) {
                count += (map.firstKey() - count);
            }
            count += map.get(map.firstKey());
            map.remove(map.firstKey());
        }
        out.print(count);
        out.close();
    }
}
