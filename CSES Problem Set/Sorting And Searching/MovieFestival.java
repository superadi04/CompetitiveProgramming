import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class MovieFestival {
    static ArrayList<Event> list = new ArrayList<Event>();
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Event(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(list);
        int count = 0;
        long last = 0;
        for (int i = 0; i < n; i++) {
            if (list.get(i).start >= last) {
                ++count;
                last = list.get(i).end;
            }
        }
        System.out.print(count);
        br.close();
    }

    static class Event implements Comparable<Event> {
        long start;
        long end;

        public Event(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(MovieFestival.Event o) {
            return Long.compare(end, o.end);
        }
    }
}
