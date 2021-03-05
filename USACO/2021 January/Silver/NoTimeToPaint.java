import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Stack;
import java.util.StringTokenizer;

public class NoTimeToPaint {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        String s = br.readLine();

        int[] prefix = new int[n + 1];
        int[] suffix = new int[n + 1];

        fill(prefix, s);
        fill(suffix, new StringBuilder().append(s).reverse().toString());

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(prefix[a - 1] + suffix[n - b]);
        }
    }

    static void fill(int[] arr, String s) {
        Stack<Character> strokes = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            arr[i + 1] = arr[i];
            while (!strokes.isEmpty() && strokes.peek() > s.charAt(i)) strokes.pop();
            if (strokes.isEmpty() || strokes.peek() < s.charAt(i)) {
                arr[i + 1]++;
                strokes.push(s.charAt(i));
            }
        }
    }
}
