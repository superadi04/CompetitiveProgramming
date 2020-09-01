import java.io.*;

public class Coprimes {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int coprime = 1;
        for (int i = 1; i < n - 1; i++) {
            if (determineCoprime(n, i)) {
                coprime = i;
            }
        }
        System.out.print(coprime);
    }

    public static boolean determineCoprime(int n, int i) {
        while (n % i != 0) {
            int temp = i;
            i = n % i;
            n = temp;
        }
        return i == 1;
    }
}
