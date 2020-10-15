import java.util.*;
import java.io.*;

public class lineup {
    static HashMap<String, HashSet<String>> pairs = new HashMap<String, HashSet<String>>();
    static String[] names = {"Beatrice", "Belinda", "Bella", "Bessie", "Betsy", "Blue", "Buttercup", "Sue"};
    static boolean[] chosen = new boolean[8];
    static int count = 0;
    static boolean check = false;
    static PrintWriter out;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("lineup.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lineup.out")));
        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            for (int j = 0; j < 4; j++) {
                st.nextToken();
            }
            if (!pairs.containsKey(a)) {
                HashSet set = new HashSet<String>();
                pairs.put(a, set);
            }
            pairs.get(a).add(st.nextToken());
        }
        search(new ArrayList<String>(), out);
        br.close();
    }

    public static void search(ArrayList<String> permutation, PrintWriter out) {
        if (permutation.size() == names.length && check(permutation)) {
            for (String s : permutation) {
                out.println(s);
            }
            out.close();
            check = true;
        } else {
            for (int i = 0; i < names.length; i++) {
                if (check) return;
                if (chosen[i]) continue;
                chosen[i] = true;
                permutation.add(names[i]);
                search(permutation, out);
                chosen[i] = false;
                permutation.remove(permutation.size() - 1);
            }
        }
    }

    public static boolean check(ArrayList<String> permutation) {
        for (Map.Entry<String, HashSet<String>> entry : pairs.entrySet()) {
            for (String s : entry.getValue()) {
                if (Math.abs(permutation.indexOf(entry.getKey()) - permutation.indexOf(s)) > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
