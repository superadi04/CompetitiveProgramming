import java.io.*;
import java.util.*;

public class fairphoto {
    static int n;
    static int ans = 0;
    static Pair[] arr;
    static int[] pref;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("fairphoto.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("fairphoto.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new Pair[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Pair(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0));
        }
        Arrays.sort(arr);
        pref = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            pref[i] = pref[i - 1] + ((arr[i - 1].cow == 'G') ? 1 : -1);
        }
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < n + 1; i++) {
            if (map.containsKey(pref[i])) {
                ans = Math.max(ans, arr[i - 1].pos - (arr[map.get(pref[i])].pos));
            } else {
                map.put(pref[i], i);
            }
        }

        boolean consec = false;
        int count = 0;
        int start = 0;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i].cow == arr[i + 1].cow) {
                if (!consec) {
                    consec = true;
                    start = i;
                }
                count++;
            } else {
                if (consec) {
                    ans = Math.max(ans, arr[start + count].pos - arr[start].pos);
                }
                count = 0;
                consec = false;
            }
        }
        ans = Math.max(ans, arr[start + count].pos - arr[start].pos);
        out.println(ans);
        out.close();
        br.close();

    }

    static class Pair implements Comparable<Pair> {
        int pos;
        char cow;

        public Pair(int pos, char cow) {
            this.pos = pos;
            this.cow = cow;
        }

        public int compareTo(Pair o) {
            return Integer.compare(pos, o.pos);
        }
    }
}
