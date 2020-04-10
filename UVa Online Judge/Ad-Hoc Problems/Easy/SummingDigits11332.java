import java.util.Scanner;

class SummingDigits11332 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        while (a != 0) {
            while (a > 9) {
                a = sumOfDigits(a);
            }
            System.out.println(a);
            a = s.nextInt();
        }
    }

    public static int sumOfDigits(int a) {
        int sum = 0;
        while (a != 0) {
            int remainder = a % 10;
            sum += remainder;
            a /= 10;
        }
        return sum;
    }
}
