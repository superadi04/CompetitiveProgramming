import java.io.*;
import java.util.*;

public class lifeguards {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new FileReader("lifeguards.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out")));
        int n = Integer.parseInt(st.nextToken());
        ArrayList<lifeguard> list = new ArrayList<lifeguard>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new lifeguard(i, a));
            list.add(new lifeguard(i, b));
        }
        Collections.sort(list);
        int[] distinct = new int[n];
        int time = 0;
        int last = 0;
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (lifeguard l : list) {
            if (set.size() == 1) {
                distinct[set.first()] += l.time - last;
            }
            if (set.size() != 0) {
                time += l.time - last;
            }
            if (set.contains(l.index)) {
                set.remove(l.index);
            } else {
                set.add(l.index);
            }
            last = l.time;
        }
        int minTime = 0;
        for (int d : distinct) {
            minTime = Math.max(minTime, time - d);
        }
        out.print(minTime);
        out.close();
        br.close();
    }
}

class lifeguard implements Comparable<lifeguard> {
    int index;
    int time;

    public lifeguard(int index, int time) {
        this.index = index;
        this.time = time;
    }

    @Override
    public int compareTo(lifeguard o) {
        return Integer.compare(this.time, o.time);
    }
}

