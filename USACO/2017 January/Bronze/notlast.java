import java.io.*;
import java.util.*;

public class notlast {
    static Cow[] cows = new Cow[7];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("notlast.in"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("notlast.out")));
        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < 7; i++) {
            cows[i] = new Cow("", 0);
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int milk = Integer.parseInt(st.nextToken());
            cows[index(name)] = new Cow(name, milk + cows[index(name)].cow);
        }
        Arrays.sort(cows);
        int check = cows[0].cow;
        String name = cows[0].name;
        boolean test = false;
        for (int i = 1; i < n; i++) {
            if (cows[i].cow > check) {
                if (i < n - 1 && cows[i + 1].cow != cows[i].cow) {
                    name = cows[i].name;
                    test = true;
                    break;
                }
            }
        }
        if (n == 1) {
            out.print(cows[6].name);
        } else {
            out.print(test ? name : "Tie");
        }
        out.close();
        br.close();
    }

    public static int index(String name) {
        switch(name) {
            case "Bessie":
                return 0;
            case "Elsie":
                return 1;
            case "Daisy":
                return 2;
            case "Gertie":
                return 3;
            case "Annabelle":
                return 4;
            case "Maggie":
                return 5;
            default:
                return 6;
        }
    }

    static class Cow implements Comparable<Cow> {
        String name;
        int cow;

        public Cow(String name, int cow) {
            this.name = name;
            this.cow = cow;
        }

        @Override
        public int compareTo(notlast.Cow o) {
            return Integer.compare(cow, o.cow);
        }
    }
}
