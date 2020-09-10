import java.io.*;
import java.util.StringTokenizer;

public class cowsignal {
    public static void main(String[] args) throws IOException {
        //BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("cowsignal.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowsignal.out")));
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < k; j++) {
                for (int a = 0; a < n; a++) {
                    for (int b = 0; b < k; b++) {
                        out.print(s.charAt(a));
                    }
                }
                out.println();
            }
        }
        out.close();
        br.close();
    }
}
