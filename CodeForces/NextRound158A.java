import java.util.Scanner;

public class NextRound158A {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] >= arr[k - 1] && arr[i] != 0) {
                count++;
            }
        }
        System.out.print(count);
    }
}
