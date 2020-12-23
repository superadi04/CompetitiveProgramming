import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        FastIO fi = new FastIO(System.in);
        int n = fi.nextInt();
        int count = 0;
        int[] nums = new int[n * n];

        // Input
        for (int i = 0; i < n * n; i++) {
            nums[count] = fi.nextInt();
            count++;
        }

        // Construct grid
        int[][] dp = new int[n][n];
        count = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = nums[count];
                count++;
            }
        }

        // Construct 2D Prefix Array
        int[][] pref = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                pref[i][j] = dp[i - 1][j - 1] + pref[i - 1][j] + pref[i][j - 1] - pref[i - 1][j - 1];
            }
        }

        int ans = Integer.MIN_VALUE;

        // Calculate maximum subrectangle
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                for (int a = 1; a <= i; a++) {
                    for (int b = 1; b <= j; b++) {
                        ans = Math.max(ans, pref[i][j] - pref[a - 1][j] - pref[i][b - 1] + pref[a - 1][b - 1]);
                    }
                }
            }
        }

        System.out.println(ans);
    }

    static class FastIO {

        InputStream dis;
        byte[] buffer = new byte[1 << 17];
        int pointer = 0;

        public FastIO(String fileName) throws Exception {
            dis = new FileInputStream(fileName);
        }

        public FastIO(InputStream is) throws Exception {
            dis = is;
        }

        int nextInt() throws Exception {
            int ret = 0;

            byte b;
            do {
                b = nextByte();
            } while (b <= ' ');
            boolean negative = false;
            if (b == '-') {
                negative = true;
                b = nextByte();
            }
            while (b >= '0' && b <= '9') {
                ret = 10 * ret + b - '0';
                b = nextByte();
            }

            return (negative) ? -ret : ret;
        }

        long nextLong() throws Exception {
            long ret = 0;

            byte b;
            do {
                b = nextByte();
            } while (b <= ' ');
            boolean negative = false;
            if (b == '-') {
                negative = true;
                b = nextByte();
            }
            while (b >= '0' && b <= '9') {
                ret = 10 * ret + b - '0';
                b = nextByte();
            }

            return (negative) ? -ret : ret;
        }

        byte nextByte() throws Exception {
            if (pointer == buffer.length) {
                dis.read(buffer, 0, buffer.length);
                pointer = 0;
            }
            return buffer[pointer++];
        }

        String next() throws Exception {
            StringBuffer ret = new StringBuffer();

            byte b;
            do {
                b = nextByte();
            } while (b <= ' ');
            while (b > ' ') {
                ret.appendCodePoint(b);
                b = nextByte();
            }

            return ret.toString();
        }

    }
}


