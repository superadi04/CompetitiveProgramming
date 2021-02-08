import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Mentors {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Pair[] arr = new Pair[n];
        int[] lookup = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(Integer.parseInt(st.nextToken()), i);
            lookup[i] = arr[i].a;
        }
        Arrays.sort(arr);
        HashSet<Integer>[] quarrels = new HashSet[n];
        for (int i = 0; i < n; i++) {
            quarrels[i] = new HashSet<>();
        }
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            quarrels[a].add(b);
            quarrels[b].add(a);
        }
        HashSet<Integer> done = new HashSet<>();
        int[] answers = new int[n];
        int prev = 0;
        int prevCount = 0;
        //HashSet<Integer> same = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (arr[i].a == prev) {
                prevCount++;
            } else {
                prevCount = 0;
            }
            int count = 0;
            for (int j : quarrels[arr[i].b]) {
                if (done.contains(j) && lookup[j] != arr[i].a) {
                    count++;
                }
            }
            answers[arr[i].b] = Math.max(0, done.size() - prevCount - count);
            done.add(arr[i].b);
            prev = arr[i].a;
        }
        for (int i : answers) {
            System.out.print(i + " ");
        }
    }

    static class Pair implements Comparable<Pair>{
        int a, b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int compareTo(Pair o) {
            return Integer.compare(a, o.a);
        }
    }
}
