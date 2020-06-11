import java.util.Scanner;

class DecrementOrIncrement {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        if (n % 4 == 0) {
            System.out.print(n + 1);
        } else {
            System.out.print(n - 1);
        }
    }
}
