import java.util.Scanner;

public class SearchingForNessy11044 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i = 0; i < 3; i++) {
            int n = s.nextInt();
            int m = s.nextInt();
            System.out.println((int)(Math.ceil(n / 3) * Math.ceil(m / 3)));
        }
    }
}
