import java.io.*;
import java.util.*;

public class GuessTheNumber {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int a = 1, b = 1000000;
        while (a < b) {
            int mid = (a + b + 1) / 2;
            System.out.println(mid);
            System.out.flush();
            String comp = sc.nextLine();
            if (comp.equals(">=")) {
                a = mid;
            } else {
                b = mid - 1;
            }
        }
        System.out.print("! " + a);
        System.out.flush();
    }
}
