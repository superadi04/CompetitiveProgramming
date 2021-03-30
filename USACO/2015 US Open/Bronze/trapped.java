import java.io.*;
import java.util.*;

public class trapped {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("trapped.in"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("trapped.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        Pair[] arr = new Pair[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(arr, Comparator.comparingInt(p -> p.pos));
        int ans = 0;
        outer: for (int i = 0; i < n - 1; i++) {
            int left = i, right = i + 1;
            boolean hasMoved = true;
            while (hasMoved) {
                hasMoved = false;
                if (arr[right].pos - arr[left].pos > arr[right].size) {
                    right++;
                    if (right >= n) continue outer;
                    hasMoved = true;
                }
                if (arr[right].pos - arr[left].pos > arr[left].size) {
                    left--;
                    if (left < 0) continue outer;
                    hasMoved = true;
                }
            }
            ans += arr[i+1].pos - arr[i].pos;
        }
        out.println(ans);
        out.close();
        br.close();
    }

    static class Pair {
        int size, pos;

        public Pair(int size, int pos) {
            this.size = size;
            this.pos = pos;
        }
    }
}
