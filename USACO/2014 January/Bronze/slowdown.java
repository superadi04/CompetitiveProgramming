import java.io.*;
import java.util.*;

public class slowdown {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("slowdown.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("slowdown.out")));
        int n = Integer.parseInt(st.nextToken());
        PriorityQueue<Double> time = new PriorityQueue<>();
        PriorityQueue<Double> distance = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            if (st.nextToken().charAt(0) == 'T') {
                time.add(Double.parseDouble(st.nextToken()));
            } else {
                distance.add(Double.parseDouble(st.nextToken()));
            }
        }
        double currSpeed = 1.0;
        double currTime = 0.0;
        double count = 1;
        double currDistance = 0.0;
        while (currDistance < 1000.0 && (!time.isEmpty() || !distance.isEmpty())) {
            // For the times
            double nextTime = Long.MAX_VALUE;
            double distanceTraveled = Long.MAX_VALUE;
            // For the distances
            double nextDistance = Long.MAX_VALUE;
            double timeTraveled = Long.MAX_VALUE;
            if (!time.isEmpty()) {
                nextTime = time.peek();
                // Calculate the distance that Bessie travels during that time
                distanceTraveled = currSpeed * (nextTime - currTime);
            }
            if (!distance.isEmpty()) {
                nextDistance = distance.peek();
                // Calculate the time at which Bessie reaches a given distance
                timeTraveled = (nextDistance - currDistance) / currSpeed;
            }
            if (nextTime < currTime + timeTraveled) {
                currDistance += distanceTraveled;
                currTime = nextTime;
                time.poll();
            } else {
                currDistance = nextDistance;
                currTime += timeTraveled;
                distance.poll();
            }
            count++;
            currSpeed = 1.0 / count;
        }
        if (currDistance < 1000.0) {
            currTime += (1000.0 - currDistance) / currSpeed;
        }
        out.println((int) Math.round(currTime));
        out.close();
        br.close();
    }
}
