import java.util.Scanner;

class ChefAndBoredGames {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i = 0; i < t; i++) {
            int n = s.nextInt();
            int area = n * n;
            int square = 0;
            int count = 0;
            while (area - square * square >= 0) {
                count += (n - square) * (n - square);
                square += 2;
            }
            System.out.println(count);
        }
    }
}
