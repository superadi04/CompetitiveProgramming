import java.io.*;
import java.util.*;

public class WhyDidTheCowCrossTheRoad {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("crossroad.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("crossroad.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            int position = Integer.parseInt(st.nextToken());

            if (map.containsKey(id) && map.get(id) != position) {
                count++;
                map.remove(id);
            }
            map.put(id, position);
        }
        out.print(count);
        out.close();
    }
}
