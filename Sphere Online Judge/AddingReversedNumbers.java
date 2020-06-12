import java.util.Scanner;

class AddingReversedNumbers {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            int a = reverse(s.nextInt());
            int b = reverse(s.nextInt());
            System.out.println(reverse(a + b));
        }
    }

    public static int reverse(int num) {
        int result = 0;
        while (num > 0) {
            int remainder = num % 10;
            result = result * 10 + remainder;
            num /= 10;
        }
        return result;
    }
}
