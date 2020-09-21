import java.io.*;
import java.util.*;

public class SumOfTwoValues {
    static ArrayList<Long> list = new ArrayList<Long>();
    static ArrayList<Long> original = new ArrayList<Long>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long x = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            long j = Long.parseLong(st.nextToken());
            list.add(j);
            original.add(j);
        }
        Collections.sort(list);
        int a = 0;
        int b = n - 1;
        while (a < b) {
            long sum = list.get(a) + list.get(b);
            if (sum == x) {
                break;
            } else if (sum < x) {
                ++a;
            } else {
                --b;
            }
        }
        if (a < b) {
            int aindex = -1;
            int bindex = -1;
            for (int i = 0; i < n; i++) {
                if ((original.get(i).equals(list.get(a))) && aindex == -1) {
                    aindex = 1 + i;
                } else if ((original.get(i).equals(list.get(b))) && bindex == -1) {
                    bindex = 1 + i;
                }
                if (aindex != -1 && bindex != -1) {
                    break;
                }
            }
            System.out.print(bindex + " " + aindex);
        } else {
            System.out.print("IMPOSSIBLE");
        }
    }
}
