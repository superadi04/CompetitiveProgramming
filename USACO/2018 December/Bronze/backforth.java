import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class backforth {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("backforth.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("backforth.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> barn1buckets = new ArrayList<>();
        ArrayList<Integer> barn2buckets = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            barn1buckets.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i++) {
            barn2buckets.add(Integer.parseInt(st.nextToken()));
        }
        solve(1000, 1000, barn1buckets, barn2buckets, 1);
        out.println(set.size());
        out.close();
        br.close();
    }

    static HashSet<Integer> set = new HashSet<>();

    static void solve(int barn1, int barn2, ArrayList<Integer> barn1buckets, ArrayList<Integer> barn2buckets, int count) {
        if (count == 5) {
            set.add(barn1);
            return;
        } else if (count % 2 == 1) {
            for (int i = 0; i < barn1buckets.size(); i++) {
                ArrayList<Integer> barn1copy = (ArrayList<Integer>) barn1buckets.clone();
                ArrayList<Integer> barn2copy = (ArrayList<Integer>) barn2buckets.clone();
                barn2copy.add(barn1copy.remove(i));
                solve(barn1 - barn2copy.get(barn2copy.size() - 1), barn2 + barn2copy.get(barn2copy.size() - 1), barn1copy, barn2copy, count + 1);
            }
        } else {
            for (int i = 0; i < barn2buckets.size(); i++) {
                ArrayList<Integer> barn1copy = (ArrayList<Integer>) barn1buckets.clone();
                ArrayList<Integer> barn2copy = (ArrayList<Integer>) barn2buckets.clone();
                barn1copy.add(barn2copy.remove(i));
                solve(barn1 + barn1copy.get(barn1copy.size() - 1), barn2 - barn1copy.get(barn1copy.size() - 1), barn1copy, barn2copy, count + 1);
            }
        }
    }
}
