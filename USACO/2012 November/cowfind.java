import java.io.*;

public class cowfind {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("cowfind.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowfind.out")));
        String s = br.readLine();
        int x = 0;
        int ans = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            String curr = s.substring(i, i + 2);
            if (checkX(curr)) {
                x++;
            } else if (checkY(curr)) {
                ans += x;
            }
        }
        out.print(ans);
        out.close();
        br.close();
    }

    static boolean checkX(String s) {
        return s.equals("((");
    }

    static boolean checkY(String s) {
        return s.equals("))");
    }
}
