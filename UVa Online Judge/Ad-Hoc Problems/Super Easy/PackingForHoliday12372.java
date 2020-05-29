import java.util.Scanner;

class PackingForHoliday12372 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int count = s.nextInt();
        for (int i = 1; i <= count; i++) {
            int l = s.nextInt();
            int w = s.nextInt();
            int h = s.nextInt();
            if (l <= 20 && w <= 20 && h <= 20) {
                System.out.println("Case " + i + ": good");
            } else {
                System.out.println("Case " + i + ": bad");
            }
        }
        s.close();
    }
}
