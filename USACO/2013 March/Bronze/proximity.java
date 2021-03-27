import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class proximity {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("proximity.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("proximity.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = -1;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i]) && i - map.get(arr[i]) <= k) {
                ans = Math.max(ans, arr[i]);
                map.put(arr[i], i);
            } else {
                map.put(arr[i], i);
            }
        }
        out.println(ans);
        out.close();
    }
}