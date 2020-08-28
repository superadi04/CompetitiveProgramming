import java.io.*;
import java.util.*;

public class Kayaking {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        ArrayList<Integer> list = new ArrayList<Integer>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n * 2; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);
        int minInstability = 1000;
        for (int i = 0; i < list.size() - 1; i++) {
            int a = list.get(i);
            list.remove(i);
            for (int j = i; j < list.size(); j++) {
                int b = list.get(j);
                list.remove(j);
                int instability = 0;
                for (int k = 0; k < list.size(); k +=2) {
                    instability += list.get(k + 1) - list.get(k);
                }
                if (instability < minInstability) {
                    minInstability = instability;
                }
                list.add(b);
                Collections.sort(list);
            }
            list.add(a);
            Collections.sort(list);
        }
        System.out.print(minInstability);
    }
}