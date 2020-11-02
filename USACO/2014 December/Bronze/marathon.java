import java.io.*;
import java.util.*;

public class marathon {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("marathon.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("marathon.out")));
        int n = Integer.parseInt(st.nextToken());
        ArrayList<Pair> checkpoints = new ArrayList<Pair>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            checkpoints.add(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        int maxDist = 0;
        for (int i = 1; i < n - 1; i++) {
            int noskip = (Math.abs(checkpoints.get(i).x - checkpoints.get(i - 1).x)) + (Math.abs(checkpoints.get(i).y - checkpoints.get(i - 1).y)) + (Math.abs(checkpoints.get(i + 1).x - checkpoints.get(i).x)) + (Math.abs(checkpoints.get(i + 1).y - checkpoints.get(i).y));
            int skip = (Math.abs(checkpoints.get(i + 1).x - checkpoints.get(i - 1).x)) + (Math.abs(checkpoints.get(i + 1).y - checkpoints.get(i - 1).y));
            if (noskip - skip > maxDist) {
                maxDist = noskip - skip;
            }
        }
        int ans = 0;
        for (int i = 1; i < n; i++) {
            ans += (Math.abs(checkpoints.get(i).x - checkpoints.get(i - 1).x)) + (Math.abs(checkpoints.get(i).y - checkpoints.get(i - 1).y));
        }
        out.print(ans - maxDist);
        out.close();
        br.close();
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
