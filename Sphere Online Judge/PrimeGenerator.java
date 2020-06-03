import java.util.Scanner;

class PrimeGenerator {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i = 0; i < t; i++) {
            int m = s.nextInt();
            int n = s.nextInt();
            for (int j = m; j <= n; j++) {
                if (isPrime(j)) {
                    System.out.println(j);
                }
            }
        }
    }

    public static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        int range = (int) Math.sqrt(n);
        for (int i = 2; i <= range; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
