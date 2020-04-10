import java.util.Scanner;

class LumberjackSequencing11942 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println("Lumberjacks:");
        for (int i = 0; i < n; i++) {
            boolean upper = false;
            boolean lower = false;
            int a = s.nextInt();
            for (int j = 0; j < 9; j++) {
                int b = s.nextInt();
                if (a < b) {
                    upper = true;
                } else if (a > b) {
                    lower = true;
                }
                a = b;
            }
            if (upper && lower) {
                System.out.println("Unordered");
            } else {
                System.out.println("Ordered");
            }
        }
    }
}

