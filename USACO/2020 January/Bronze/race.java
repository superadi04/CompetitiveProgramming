import java.io.*;
import java.util.StringTokenizer;

public class race {
    static int k, n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("race.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("race.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            out.println(solve(Integer.parseInt(st.nextToken())));
        }
        out.close();
        br.close();
    }

    static int solve(int x) {
        int left = 0;
        int right = 0;
        int time = 0;
        for (int currspeed = 1;; currspeed++) {
            left += currspeed;
            time++;
            if (left + right >= n) return time;
            if (currspeed >= x) {
                right += currspeed;
                time++;
            }
            if (left + right >= n) return time;
        }
    }
}
