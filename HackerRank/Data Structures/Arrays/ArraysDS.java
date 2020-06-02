import java.util.Scanner;

public class ArraysDS {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] arr = new int[s.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.nextInt();
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
    }
}
