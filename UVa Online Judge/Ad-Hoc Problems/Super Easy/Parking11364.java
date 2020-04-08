import java.util.Arrays;
import java.util.Scanner;

class Parking11364 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i = 0; i < t; i++) {
            int numStores = s.nextInt();
            int[] arr = new int[numStores];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = s.nextInt();
            }
            Arrays.sort(arr);
            System.out.println((arr[arr.length - 1] - arr[0]) * 2);
        }
    }
}
