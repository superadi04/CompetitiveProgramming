import java.util.Scanner;

class FlatLand {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i = 0; i < t; i++) {
            int count = 0;
            int div = 1;
            int n = s.nextInt();
            while (n > 0) {
                div = 1;
                while (n - div * div >= 0) {
                    div++;
                }
                div -= 1;
                n -= div * div;
                count++;
            }
            System.out.println(count);
        }
    }
}

