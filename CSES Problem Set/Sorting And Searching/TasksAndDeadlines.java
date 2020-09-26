import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class TasksAndDeadlines {
    static ArrayList<Task> list = new ArrayList<Task>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Task(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(list);
        long currTime = 0;
        long score = 0;
        for (int i = 0; i < n; i++) {
            currTime += list.get(i).duration;
            score += (list.get(i).deadline - currTime);
        }
        System.out.print(score);
        br.close();
    }

    static class Task implements Comparable<Task> {
        int duration;
        int deadline;

        public Task(int duration, int deadline) {
            this.duration = duration;
            this.deadline = deadline;
        }

        public int compareTo(Task o) {
            return Integer.compare(duration, o.duration);
        }
    }
}
