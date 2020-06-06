import java.util.Scanner;

public class SoldierAndBananas546A {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int k = s.nextInt();
        int n = s.nextInt();
        int w = s.nextInt();
        int totalCost = 0;
        for (int i = 1; i <= w; i++) {
            totalCost += i * k;
        }
        if (n - totalCost < 0) {
            System.out.print(totalCost - n);
        } else {
            System.out.print(0);
        }
    }
}
