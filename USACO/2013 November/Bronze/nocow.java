import java.io.*;
import java.util.*;

class nocow {
    static ArrayList<String> check = new ArrayList<>();
    static ArrayList<TreeSet<String>> nocows = new ArrayList<>();
    static int totalCombos = 1;
    static int divisors[];

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("nocow.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("nocow.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n, k;
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int nocowcount = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                st.nextToken();
            }
            int count = 0;
            String s;
            String combo = "";

            while (!(s = st.nextToken()).equals("cow.")) {
                if (count == nocows.size()) {
                    TreeSet<String> set = new TreeSet<>();
                    nocows.add(set);
                }
                nocows.get(count).add(s);
                combo += s;
                count++;
            }

            check.add(combo);
            nocowcount++;
        }
        for (TreeSet<String> s : nocows) {
            totalCombos *= s.size();
        }

        divisors = new int[nocows.size()];
        int denom = totalCombos;
        for (int i = 0; i < nocows.size(); i++) {
            divisors[i] = denom;
            denom /= nocows.get(i).size();
        }

        String withoutK;
        int prevremoveK = 0;
        int removeK = 0;
        do {
            prevremoveK += (removeK - prevremoveK);
            withoutK = solve(k + prevremoveK).replaceAll(" ", "");
            removeK = 0;
            for (String s : check) {
                if (s.compareTo(withoutK) <= 0) {
                    removeK++;
                }
            }
        }
        while (removeK != prevremoveK);

        out.println(solve(k + prevremoveK).trim());
        out.close();
        br.close();

    }

    static String solve(int k) {
        int count = 0;
        String ans = "";
        int curr = 0;

        while (count < nocows.size()) {
            int currCount = (divisors[count] / nocows.get(count).size());
            for (String s : nocows.get(count)) {
                if (currCount + curr >= k) {
                    curr += currCount - (divisors[count] / nocows.get(count).size());
                    ans += s + " ";
                    break;
                } else {
                    currCount += (divisors[count] / nocows.get(count).size());
                }
            }
            count++;
        }

        return ans;
    }
}