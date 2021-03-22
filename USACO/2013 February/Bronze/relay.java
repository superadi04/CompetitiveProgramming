import java.io.*;

public class relay {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("relay.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("relay.out")));
        int n = Integer.parseInt(br.readLine());
        int[] messages = new int[n];
        for (int i = 0; i < n; i++) {
            messages[i] = Integer.parseInt(br.readLine()) - 1;
        }
        int count = 0;
        outer: for (int i = 0; i < n; i++) {
            boolean[] vis = new boolean[n];
            int index = i;
            do {
                if (messages[index] == -1) {
                    count++;
                    continue outer;
                }
                vis[index] = true;
                index = messages[index];
            } while (!vis[index]);
        }
        out.println(count);
        out.close();
        br.close();
    }
}
