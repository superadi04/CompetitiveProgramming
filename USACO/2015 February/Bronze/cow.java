import java.io.*;

public class cow {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("cow.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cow.out")));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        long ans = 0;
        long o = 0;
        long c = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'C') {
                c++;
            } else if (s.charAt(i) == 'O') {
                o += c;
            } else {
                ans += o;
            }
        }
        out.println(ans);
        out.close();
        br.close();
    }
}
