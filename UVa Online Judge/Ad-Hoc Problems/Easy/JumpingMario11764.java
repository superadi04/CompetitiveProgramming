import java.util.Scanner;

class JumpingMario11764 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i = 1; i <= t; i++) {
            int highJumps = 0;
            int lowJumps = 0;
            int arr[] = new int[s.nextInt()];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = s.nextInt();
            }
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    highJumps++;
                } else if (arr[j] > arr[j + 1]) {
                    lowJumps++;
                }
            }
            System.out.println("Case " + i + ": " + highJumps + " " + lowJumps);
        }
    }
}
