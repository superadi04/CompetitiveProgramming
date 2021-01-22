import java.io.*;
import java.util.*;

public class triangles {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("triangles.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("triangles.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());

        // Stores coordinates --> Key is x coordinate, values are y coordinates
        TreeMap<Long, ArrayList<Long>> xcoor = new TreeMap<>();
        // Stores coordinates --> Key is y coordinates, values are x coordinates
        TreeMap<Long, ArrayList<Long>> ycoor = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());

            if (xcoor.containsKey(x)) {
                xcoor.get(x).add(y);
            } else {
                ArrayList<Long> list = new ArrayList<>();
                list.add(y);
                xcoor.put(x, list);
            }

            if (ycoor.containsKey(y)) {
                ycoor.get(y).add(x);
            } else {
                ArrayList<Long> list = new ArrayList<>();
                list.add(x);
                ycoor.put(y, list);
            }
        }

        // Sort everything
        for (Map.Entry<Long, ArrayList<Long>> entry : xcoor.entrySet()) {
            Collections.sort(entry.getValue());
        }
        for (Map.Entry<Long, ArrayList<Long>> entry : ycoor.entrySet()) {
            Collections.sort(entry.getValue());
        }

        long mod = 1000000007;
        HashMap<Long, HashMap<Long, Long>> answers = new HashMap<>();

        for (Map.Entry<Long, ArrayList<Long>> entry : xcoor.entrySet()) {
            long sum = 0;
            for (int i = 1; i < entry.getValue().size(); i++) {
                sum += (entry.getValue().get(i) - entry.getValue().get(0));
            }
            HashMap<Long, Long> map = new HashMap<>();
            map.put(entry.getValue().get(0), sum);
            answers.put(entry.getKey(), map);
            for (int i = 1; i < entry.getValue().size(); i++) {
                sum -= (entry.getValue().size() - 2 * i) * (entry.getValue().get(i) - entry.getValue().get(i - 1));
                answers.get(entry.getKey()).put(entry.getValue().get(i), sum);
            }
        }

        long ans = 0;

        for (Map.Entry<Long, ArrayList<Long>> entry : ycoor.entrySet()) {
            long sum = 0;
            for (int i = 1; i < entry.getValue().size(); i++) {
                sum += (entry.getValue().get(i) - entry.getValue().get(0));
            }
            ans = (ans + (answers.get(entry.getValue().get(0)).get(entry.getKey()) * sum) % mod) % mod;
            for (int i = 1; i < entry.getValue().size(); i++) {
                sum -= (entry.getValue().size() - 2 * i) * (entry.getValue().get(i) - entry.getValue().get(i - 1));
                ans = (ans + (answers.get(entry.getValue().get(i)).get(entry.getKey()) * sum) % mod) % mod;
            }
        }

        out.println(ans);
        out.close();
        br.close();
    }
}