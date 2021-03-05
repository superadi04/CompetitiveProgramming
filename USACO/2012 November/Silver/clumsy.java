import java.io.*;

public class clumsy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("clumsy.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("clumsy.out")));
        String s = br.readLine();
        int pref = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                pref++;
            } else {
                if (pref == 0) {
                    pref++;
                    ans++;
                } else {
                    pref--;
                }
            }
        }
        out.print(ans + pref / 2);
        out.close();
        br.close();
    }
}
