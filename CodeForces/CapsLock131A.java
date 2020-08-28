import java.io.*;

public class CapsLock131A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        if (s.substring(1, s.length()).equals(s.substring(1, s.length()).toUpperCase())) {
            String last = "";
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) > 96) {
                    last += (char) (s.charAt(i) - 32);
                } else {
                    last += (char) (s.charAt(i) + 32);
                }
            }
            s = last;
        }
        System.out.print(s);
    }
}