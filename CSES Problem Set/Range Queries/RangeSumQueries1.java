import java.io.*;

public class RangeSumQueries1 {
    public static void main(String[] args) throws Exception {
        FastIO fi = new FastIO(System.in);
        int n = fi.nextInt();
        int q = fi.nextInt();
        long[] pref = new long[n + 1];
        for (int i = 1; i < n + 1; i++) {
            pref[i] += pref[i - 1] + fi.nextLong();
        }
        for (int i = 0; i < q; i++) {
            int a = fi.nextInt();
            int b = fi.nextInt();
            System.out.println(pref[b] - pref[a - 1]);
        }
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


