import java.io.*;
import java.util.*;

public class moop {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("moop.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("moop.out")));
        int n = Integer.parseInt(st.nextToken());
        Particle[] arr = new Particle[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Particle(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(arr);
        int[] miny = new int[n];
        miny[0] = arr[0].y;
        for (int i = 1; i < n; i++) {
            miny[i] = Math.min(miny[i - 1], arr[i].y);
        }
        int[] maxy = new int[n];
        maxy[n - 1] = arr[n - 1].y;
        for (int i = n - 2; i >= 0; i--) {
            maxy[i] = Math.max(maxy[i + 1], arr[i].y);
        }
        int ans = 1;
        for (int i = 0; i < n - 1; i++) {
            if (miny[i] > maxy[i + 1]) {
                ++ans;
            }
        }
        out.print(ans);
        out.close();
        br.close();
    }

    static class Particle implements Comparable<Particle>{
        int x;
        int y;

        public Particle(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Particle o) {
            if (x == o.x) return Integer.compare(y, o.y);
            return Integer.compare(x, o.x);
        }
    }
}
