import java.util.Scanner;
import java.util.stream.IntStream;

class RobotInstructions12503 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i = 0; i < t; i++) {
            int[] positions = new int[s.nextInt()];
            for (int j = 0; j < positions.length; j++) {
                String word = s.next();
                if (word.equals("LEFT")) {
                    positions[j] = -1;
                } else if (word.equals("RIGHT")) {
                    positions[j] = 1;
                } else {
                    s.next();
                    positions[j] = positions[s.nextInt() - 1];
                }
            }
            System.out.println(IntStream.of(positions).sum());
        }
    }
}
