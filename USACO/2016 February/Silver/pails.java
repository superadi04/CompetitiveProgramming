import java.util.*;
import java.io.*;

public class pails {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("pails.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pails.out")));
        int x, y, k, m;
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        boolean[][] vis = new boolean[x + 1][y + 1];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0, 0));
        int ans = m;
        vis[0][0] = true;
        while (!q.isEmpty()) {
            Pair p = q.poll();
            ans = Math.min(ans, Math.abs(m - p.pail1 - p.pail2));
            ArrayList<Pair> pails = new ArrayList<>();

            // Filled up pails
            pails.add(new Pair(x, p.pail2, p.operationNum + 1));
            pails.add(new Pair(p.pail1, y, p.operationNum + 1));

            // Empty pails
            pails.add(new Pair(0, p.pail2, p.operationNum + 1));
            pails.add(new Pair(p.pail1, 0, p.operationNum + 1));

            // Pouring pails
            pails.add(new Pair(Math.max(0, p.pail1 + p.pail2 - y), Math.min(y, p.pail2 + p.pail1), p.operationNum + 1));
            pails.add(new Pair(Math.min(x, p.pail2 + p.pail1), Math.max(0, p.pail2 + p.pail1 - x), p.operationNum + 1));

            for (Pair pail : pails) {
                if (!vis[pail.pail1][pail.pail2] && pail.operationNum <= k) {
                    vis[pail.pail1][pail.pail2] = true;
                    q.add(pail);
                }
            }
        }
        out.println(ans);
        out.close();
        br.close();
    }

    static class Pair {
        int pail1;
        int pail2;
        int operationNum;

        public Pair(int pail1, int pail2, int operationNum) {
            this.pail1 = pail1;
            this.pail2 = pail2;
            this.operationNum = operationNum;
        }
    }
}
