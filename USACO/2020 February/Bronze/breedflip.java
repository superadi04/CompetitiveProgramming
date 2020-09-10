import java.io.*;

public class breedflip {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("breedflip.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("breedflip.out")));
        int n = Integer.parseInt(br.readLine());
        String a = br.readLine();
        String b = br.readLine();
        int count = 0;
        for (int i = 0; i < n; i++) {
            boolean test = false;
            while (i < n && a.charAt(i) != b.charAt(i)) {
                ++i;
                test = true;
            }
            if (test) {
                ++count;
            }
        }
        out.print(count);
        out.close();
        br.close();
    }
}
