import java.util.Scanner;

class TheSnail573 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double heightOfWall;
        while ((heightOfWall = s.nextDouble()) != 0) {
            double distanceClimbedPerDay = s.nextDouble();
            double distanceSlidInNight = s.nextDouble();
            double fatigueFactor = s.nextDouble() / 100 * distanceClimbedPerDay;
            double currentHeight = 0;
            int countDays = 1;
            while (true) {
                if (distanceClimbedPerDay >= 0) {
                    currentHeight += distanceClimbedPerDay;
                }
                if (currentHeight > heightOfWall) {
                    System.out.println("success on day " + countDays);
                    break;
                }
                currentHeight -= distanceSlidInNight;
                if (currentHeight < 0) {
                    System.out.println("failure on day " + countDays);
                    break;
                }
                countDays++;
                distanceClimbedPerDay -= fatigueFactor;
            }
        }
    }
}