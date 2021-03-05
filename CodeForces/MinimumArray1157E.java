import java.io.*;
import java.util.*;

public class MinimumArray1157E {
    static TreeMap<Integer, Integer> b = new TreeMap<Integer, Integer>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            add(Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i < n; i++) {
            int min = b.firstKey();
            int max = -1;
            if (n - a[i] <= b.lastKey()) max = b.ceilingKey(n - a[i]);
            if (max != -1) {
                System.out.print(Math.min((a[i] + min) % n, (a[i] + max) % n) + " ");
                if ((a[i] + max) % n <= (a[i] + min) % n) {
                    remove(max);
                } else {
                    remove(min);
                }
            } else {
                System.out.print((a[i] + min) % n + " ");
                remove(min);
            }
        }
    }

    static void add(int x){
        if(b.containsKey(x)){
            b.put(x, b.get(x) + 1);
        } else {
            b.put(x, 1);
        }
    }

    static void remove(int x){
        b.put(x, b.get(x) - 1);
        if(b.get(x) == 0){
            b.remove(x);
        }
    }
}
