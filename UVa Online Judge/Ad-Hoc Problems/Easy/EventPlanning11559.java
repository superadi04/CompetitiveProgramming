import java.util.Scanner;

class EventPlanning11559 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            int numParticipants = s.nextInt();
            int budget = s.nextInt();
            int numHotels = s.nextInt();
            int numWeeks = s.nextInt();
            boolean test = false;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < numHotels; i++) {
                int pricePerPerson = s.nextInt();
                for (int j = 0; j < numWeeks; j++) {
                    int numAvailableBeds = s.nextInt();
                    if (numParticipants <= numAvailableBeds && pricePerPerson * numParticipants <= budget) {
                        min = Math.min(min, pricePerPerson * numParticipants);
                        test = true;
                    }
                }
            }
            if (test) {
                System.out.println(min);
            } else {
                System.out.println("stay home");
            }
        }
    }
}
