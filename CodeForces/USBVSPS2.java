import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class USBVSPS2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        Pair[] mice = new Pair[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            mice[i] = new Pair(Integer.parseInt(st.nextToken()), (st.nextToken().equals("USB")) ? 0 : 1);
        }
        Arrays.sort(mice);
        long equip = 0;
        long cost = 0;
        for (Pair p : mice) {
            if ((p.type == 0 && a > 0) || (p.type == 1 && b > 0) || (c > 0)) {
                equip++;
                cost += p.price;
            }
            if (p.type == 0 && a > 0) a--;
            else if (p.type == 1 && b > 0) b--;
            else if (c > 0) c--;
        }
        System.out.println(equip + " " + cost);
    }

    static class Pair implements Comparable<Pair>{
        int price, type;

        public Pair(int price, int type) {
            this.price = price;
            this.type = type;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(price, o.price);
        }
    }
}
