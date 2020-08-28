
import java.io.*;
import java.util.*;

public class lifeguards {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("lifeguards.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        ArrayList<shift> lifeguards = new ArrayList<shift>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            lifeguards.add(new shift(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(lifeguards);

        int maxTime = 0;
        for (int i = 0; i < n; i++) {
            shift removal = lifeguards.get(i);
            lifeguards.remove(i);
            int time = 0;
            time += lifeguards.get(0).endTime - lifeguards.get(0).startTime;
            for (int j = 0; j < n - 2; j++) {
                if (lifeguards.get(j).endTime >= lifeguards.get(j + 1).startTime) {
                    time += (lifeguards.get(j + 1).endTime - lifeguards.get(j).endTime);
                } else {
                    time += (lifeguards.get(j + 1).endTime - lifeguards.get(j + 1).startTime);
                }
            }
            if (time > maxTime) {
                maxTime = time;
            }
            lifeguards.add(removal);
            Collections.sort(lifeguards);
        }

        out.print(maxTime);
        out.close();
    }
}

class shift implements Comparable<shift> {
    int startTime, endTime;

    public shift(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int compareTo(shift s) {
        return Integer.compare(startTime, s.startTime);
    }
}
