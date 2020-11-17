import java.io.*;
import java.util.*;

public class auto {
    static Pair[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("auto.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("auto.out")));
        int w = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        arr = new Pair[w];
        for (int i = 0; i < w; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Pair(st.nextToken(), i + 1);
        }
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            int lower = lowerBound(s);
            int upper = upperBound(s);
            if (upper - lower >= k) {
                out.println(arr[lower + k - 1].index);
            } else {
                out.println(-1);
            }
        }
        out.close();
        br.close();
    }

    static class Pair implements Comparable<Pair> {
        String s;
        int index;

        public Pair(String s, int index) {
            this.s = s;
            this.index = index;
        }

        public int compareTo(Pair o) {
            return s.compareTo(o.s);
        }
    }

    public static int upperBound(String a) {
        int low = 0;
        int high = arr.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (a.compareTo(arr[mid].s) > 0|| (a.length() <= arr[mid].s.length() && a.equals(arr[mid].s.substring(0, a.length())))) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static int lowerBound(String a) {
        int low = 0;
        int high = arr.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (a.compareTo(arr[mid].s) > 0) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }


}
