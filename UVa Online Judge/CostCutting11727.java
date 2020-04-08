import java.util.Arrays;
import java.util.Scanner;

class CostCutting11727 {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int[] arr = new int[3];
        int numCases = s.nextInt();
        for (int i = 1; i <= numCases; i++) {
            for (int j = 0; j < 3; j++) {
                arr[j] = s.nextInt();
            }
            Arrays.sort(arr);
            System.out.println("Case " + i + ": " + arr[1]);
        }
    }
}
