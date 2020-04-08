import java.util.Scanner;

class HorrorDash11799 {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int numCases = s.nextInt();
        for (int i = 1; i <= numCases; i++) {
            int max = Integer.MIN_VALUE;
            int numStudentsPerCase = s.nextInt();
            for (int j = 0; j < numStudentsPerCase; j++) {
                max  = Math.max(max, s.nextInt());
            }
            System.out.println("Case " + i + ": " + max);
        }
    }
}
