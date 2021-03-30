import java.io.*;

public class censor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("censor.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("censor.out")));
        StringBuilder s = new StringBuilder(br.readLine());
        String t = br.readLine();
        for (int i = 0; i <= s.length() - t.length(); i++) {
            if (s.substring(i, i + t.length()).equals(t)) {
                s.delete(i, i + t.length());
                i = Math.max(0, i - t.length());
            }
        }
        out.println(s);
        out.close();
        br.close();
    }
}
