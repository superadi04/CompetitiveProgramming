import java.io.*;
import java.util.StringTokenizer;

public class greetings {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("greetings.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("greetings.out")));
        int b = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        Pair[] bessie = new Pair[b];
        Pair[] elsie = new Pair[e];

        int bcount = 0;
        int ecount = 0;

        for (int i = 0; i < b; i++) {
            st = new StringTokenizer(br.readLine());
            int dist = Integer.parseInt(st.nextToken());
            bessie[i] = new Pair(dist, (st.nextToken().charAt(0) == 'R') ? 1 : -1);
            bcount += dist;
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int dist = Integer.parseInt(st.nextToken());
            elsie[i] = new Pair(dist, (st.nextToken().charAt(0) == 'R') ? 1 : -1);
            ecount += dist;
        }

        int ans = 0;

        int currB = 0, currE = 0;
        int bc = 1, ec = 1;
        int bessiePos = 0, elsiePos = 0;
        boolean together = true;
        for (int i = 0; i < Math.max(bcount, ecount); i++) {
            if (currB < b && bc > bessie[currB].dist) {
                currB++;
                bc = 1;
            }
            if (currE < e && ec > elsie[currE].dist) {
                currE++;
                ec = 1;
            }
            if (currB < b) {
                bessiePos += (1 * bessie[currB].dir);
            }
            if (currE < e) {
                elsiePos += (1 * elsie[currE].dir);
            }
            if (bessiePos == elsiePos && !together) {
                ans++;
                together = true;
            } else if (bessiePos != elsiePos) {
                together = false;
            }
            bc++;
            ec++;
        }
        out.println(ans);
        out.close();
        br.close();
    }

    static class Pair {
        int dist;
        int dir;

        public Pair(int dist, int dir) {
            this.dist = dist;
            this.dir = dir;
        }
    }
}
