import java.util.Scanner;

class TariffPlan12157 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = s.nextInt();
            int totalMile = 0, totalJuice = 0;
            for (int j = 0; j < n; j++) {
                int call = s.nextInt();
                totalMile += (Math.ceil(call / 30 + 1) * 10);
                totalJuice += (Math.ceil(call / 60 + 1) * 15);
            }
            if (totalJuice > totalMile) {
                System.out.println("Case " + i + ": Mile " + totalMile);
            } else if (totalJuice < totalMile) {
                System.out.println("Case " + i + ": Juice " + totalJuice);
            } else {
                System.out.println("Case " + i + ": Mile Juice " + totalMile);
            }
        }
    }
}
