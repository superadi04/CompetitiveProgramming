import java.util.Scanner;

public class BeautifulMatrix263A {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[][] arr = new int[5][5];
        int x = 0;
        int y = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = s.nextInt();
                if (arr[i][j] == 1) {
                    x = i;
                    y = j;
                }
            }
        }
        System.out.print((Math.abs(2 - x)) + Math.abs(2 - y));
    }
}
