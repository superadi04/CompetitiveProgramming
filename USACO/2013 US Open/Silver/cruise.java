import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class cruise {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("cruise.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cruise.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n, m;
        long k;
        n = Integer.parseInt(st.nextToken()); // Number of ports
        m = Integer.parseInt(st.nextToken()); // Length of sequence
        k = Integer.parseInt(st.nextToken()); // Number of times sequence repeated

        // Contains left and right river at each port
        Pair[] ports = new Pair[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            ports[i] = new Pair(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
        }

        // Contains sequence
        char[] seq = new char[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            seq[i] = st.nextToken().charAt(0);
        }

        // To determine if we have visited a given port
        boolean[] vis = new boolean[n];

        // Contains ports we have visited till we reach a cycle
        ArrayList<Integer> al = new ArrayList<>();

        // Current index of port at which we are at
        int currIndex = 0;

        do {
            al.add(currIndex);
            vis[currIndex] = true; // We have visited this port.
            // Perform the sequence
            for (char c : seq) {
                if (c == 'L') {
                    currIndex = ports[currIndex].a;
                } else {
                    currIndex = ports[currIndex].b;
                }
            }
        } while (!vis[currIndex]);

        int i = al.indexOf(currIndex);
        double numer = (k - al.size() + 1);
        double denom = al.size() - i;
        out.println(al.get((int) ((k + (Math.ceil(numer / denom) * i)) % al.size())) + 1);
        out.close();
        br.close();
    }

    static class Pair {
        int a, b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}