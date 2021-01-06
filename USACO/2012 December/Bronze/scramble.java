import java.io.*;
import java.util.Arrays;


public class scramble {
    static String[] bestcase;
    static String[] worstcase;
    static Pair[] names;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("scramble.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("scramble.out")));
        int n = Integer.parseInt(br.readLine());
        bestcase = new String[n];
        worstcase = new String[n];
        names = new Pair[n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            char[] best = new char[s.length()];
            char[] worst = new char[s.length()];
            for (int j = 0; j < s.length(); j++) {
                best[j] = s.charAt(j);
            }
            Arrays.sort(best);
            for (int j = 0; j < best.length; j++) {
                worst[Math.abs(j - best.length + 1)] = best[j];
            }
            String a = String.valueOf(best);
            String b = String.valueOf(worst);
            names[i] = new Pair(a, b);
            bestcase[i] = a;
            worstcase[i] = b;
        }
        Arrays.sort(bestcase);
        Arrays.sort(worstcase);
        for (Pair p : names) {
            out.println(lower(p.higher) + " " + higher(p.lower));
        }
        out.close();
        br.close();
    }

    static int lower(String check) {
        int lo = 0, hi = bestcase.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (check.compareTo(worstcase[mid]) <= 0) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo + 1;
    }

    static int higher(String check) {
        int lo = 0, hi = bestcase.length - 1;
        while (lo < hi) {
            int mid = (lo + hi + 1) / 2;
            if (check.compareTo(bestcase[mid]) >= 0) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return lo + 1;
    }

    static class Pair {
        String higher, lower;

        public Pair(String higher, String lower) {
            this.higher = higher;
            this.lower = lower;
        }
    }
}
