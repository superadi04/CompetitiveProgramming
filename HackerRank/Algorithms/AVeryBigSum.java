import java.util.Scanner;

public class AVeryBigSum {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += s.nextLong();
        }
        System.out.println(sum);
    }
}
