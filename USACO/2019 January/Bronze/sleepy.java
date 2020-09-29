import java.io.*;
import java.util.StringTokenizer;

public class sleepy {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("sleepy.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sleepy.out")));
        int n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        out.print(steps());
        out.close();
        br.close();
    }

    public static int steps() {
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i - 1] + 1 > arr[i]) {
                return i;
            }
        }
        return 0;
    }
}
