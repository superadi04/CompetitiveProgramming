import java.util.Scanner;

class EmoogleBalance12279 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n;
        int count = 1;
        int giveTreat = 0;
        int givenTreat = 0;
        while (!((n = s.nextInt()) == 0)) {
            for (int i = 0; i < n; i++) {
                if (s.nextInt() == 0) {
                    givenTreat++;
                } else {
                    giveTreat++;
                }
            }
            System.out.println("Case " + count + ": " + (giveTreat - givenTreat));
            count++;
            givenTreat = 0;
            giveTreat = 0;
        }
    }
}
