import java.io.*;
import java.util.*;

public class swap {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("swap.in"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("swap.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] seq = new int[2][2];
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            seq[i][0] = Integer.parseInt(st.nextToken()) - 1;
            seq[i][1] = Integer.parseInt(st.nextToken()) - 1;
        }

        int[] answers = new int[n];
        int[] cows = new int[n];

        for (int i = 0; i < n; i++) {
            cows[i] = i;
        }

        for (int i = 0; i < n; i++) {
            int index = i;
            boolean[] vis = new boolean[n];
            ArrayList<Integer> sequence = new ArrayList<>();
            do {
                sequence.add(index);
                vis[index] = true;
                for (int j = 0; j < 2; j++) {
                    if (index >= seq[j][0] && index <= seq[j][1]) {
                        index = -index + seq[j][0] + seq[j][1];
                    }
                }
            } while (!vis[index]);
            int stop = sequence.indexOf(index);
            answers[sequence.get(((k + (((k - sequence.size() + 1) / (sequence.size() - stop)) * stop)) % sequence.size()))] = i + 1;
        }

        for (int i : answers) {
            out.println(i);
        }
        out.close();
        br.close();
    }
}
