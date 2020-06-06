import java.util.Scanner;

public class Team231A {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int finalCount = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < 3; j++) {
                if (s.nextInt() == 1) {
                    count++;
                }
            }
            if (count >= 2) {
                finalCount++;
            }
        }
        System.out.print(finalCount);
    }
}
