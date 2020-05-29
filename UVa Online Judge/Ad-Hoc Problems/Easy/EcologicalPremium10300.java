import java.util.Scanner;

class EcologicalPremium10300 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int numCases = s.nextInt();
        for (int i = 0; i < numCases; i++) {
            int f = s.nextInt();
            int sum = 0;
            for (int j = 0; j < f; j++) {
                int a = s.nextInt();
                s.nextInt();
                sum += (a * s.nextInt());
            }
            System.out.println(sum);
        }
    }
}
