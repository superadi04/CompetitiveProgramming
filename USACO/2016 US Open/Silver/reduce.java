import java.util.*;
import java.io.*;

public class reduce {
    //static int total;
    static Pair[] x;
    static Pair[] y;
    static boolean[] chosen;
    static int ans = Integer.MAX_VALUE;
    static multiset<Integer> xvals = new multiset<>();
    static multiset<Integer> yvals = new multiset<>();

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("reduce.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("reduce.out")));
        int n = Integer.parseInt(st.nextToken());
        x = new Pair[n];
        y = new Pair[n];
        chosen = new boolean[12];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            x[i] = new Pair(x1, y1);
            y[i] = new Pair(y1, x1);
        }
        Arrays.sort(x);
        Arrays.sort(y);
        for (Pair p : y) {
            int temp = p.b;
            p.b = p.a;
            p.a = temp;
            xvals.add(p.a);
            yvals.add(p.b);
        }
        //total = (y[n - 1].a - y[0].a) * (x[n - 1].a - x[0].a);
        ArrayList<Pair> vals = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            vals.add(x[i]);
            vals.add(y[i]);
            vals.add(x[n - 1 - i]);
            vals.add(y[n - 1 - i]);
        }
        //search(new ArrayList<Pair>(), vals, 0);
        ArrayList<Pair> permutation = new ArrayList<Pair>();
        for (int i = 0; i < 10; i++) {
            permutation.add(vals.get(i));
            for (int j = i + 1; j < 11; j++) {
                permutation.add(vals.get(j));
                for (int k = j + 1; k < 12; k++) {
                    permutation.add(vals.get(k));
                    multiset<Integer> xvalstemp = (multiset<Integer>) xvals.clone();
                    multiset<Integer> yvalstemp = (multiset<Integer>) yvals.clone();
                    for (Pair p : permutation) {
                        if (xvalstemp.containsKey(p.a)) xvalstemp.remove1(p.a);
                        if (yvalstemp.containsKey(p.b)) yvalstemp.remove1(p.b);
                    }
                    ans = Math.min(ans, (xvalstemp.lastKey() - xvalstemp.firstKey()) * (yvalstemp.lastKey() - yvalstemp.firstKey()));
                    permutation.remove(permutation.size() - 1);
                }
                permutation.remove(permutation.size() - 1);
            }
            permutation.remove(permutation.size() - 1);
        }
        //multiset<Integer> yval = new multiset<>(); // Current y values for range x
       // multiset<Integer> xval = new multiset<>(); // Current x values for range y

        //int start = 0;
        //int end = n - 4;
        /*do {
            // Find minimum for both x and y
            ans = Math.min(ans, (x[end].a - x[start].a) * (yval.lastKey() - yval.firstKey()));
            ans = Math.min(ans, (y[end].a - y[start].a) * (xval.lastKey() - xval.firstKey()));

            // Remove previous elements from multisets
            yval.remove1(x[start].b);
            xval.remove1(y[start].b);

            // Increment pointers
            start++;
            end++;

            // Add new element
            if (end < n) {
                yval.add(x[end].b);
                xval.add(y[end].b);
            }
        } while (end < n);*/

        out.print(ans);
        out.close();
        br.close();
    }

    /*static void search(ArrayList<Pair> permutation, ArrayList<Pair> vals, int start) {
        if (permutation.size() == 3) {
            //int minx = Integer.MAX_VALUE;
            //int maxx = 0;
            //int miny = Integer.MAX_VALUE;
            //int maxy = 0;
            multiset<Integer> xvalstemp = xvals;
            multiset<Integer> yvalstemp = yvals;
            for (Pair p : permutation) {
                if (xvalstemp.containsKey(p.a)) xvalstemp.remove1(p.a);
                if (yvalstemp.containsKey(p.b)) yvalstemp.remove1(p.b);
            }
            ans = Math.min(ans, (xvalstemp.lastKey() - xvalstemp.firstKey()) * (yvalstemp.lastKey() - yvalstemp.firstKey()));
            //for (Pair p : permutation) {
            //    xvals.add(p.a);
            //    yvals.add(p.b);
            //}
        } else {
            for (int i = start; i < 12; i++) {
                permutation.add(vals.get(i));
                search(permutation, vals, i);
                permutation.remove(permutation.size() - 1);
            }
        }
    }*/

    static class Pair implements Comparable<Pair> {
        int a, b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int compareTo(Pair o) {
            if (a == o.a) {
                return Integer.compare(b, o.b);
            }
            return Integer.compare(a, o.a);
        }
    }

    public static class multiset<K> extends TreeMap<K,Integer>{
        public void add(K x) {
            if (this.containsKey(x)) {
                this.put(x,this.get(x)+1);
            }
            else {
                this.put(x,1);
            }
        }
        public void remove1 (K x) {
            if (!this.containsKey(x)) return;
            this.put(x,this.get(x)-1);
            if (this.get(x) == 0) {
                this.remove(x);
            }
        }
    }
}
