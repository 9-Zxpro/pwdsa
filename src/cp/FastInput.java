package cp;


import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FastInput {

    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    static Reader in = new Reader();
    static long LNF = Long.MAX_VALUE;
    static int INF = Integer.MAX_VALUE;


    public static void main(String[] args) {

//---------Code starts here---------
        int t = in.nextInt();

        while (t-- > 0) {
            solve();
        }
        out.close();
    }

    public static void solve() {
//        int n = in.nextInt();
//        int m = in.nextInt();

    }


//           _____________________
//          |                     |
//          |   Programmer.java   |
//          |_____________________|
//                /        \
//               /  O    O  \
//              (      o     )
//               \    _^_   /
//                \________/
//
    public static <T> void printArrayList(ArrayList<T> arrList) {
        for (T x : arrList) {
            out.print(x + " ");
        }
        out.println();
    }

    public static void printIntArray(int[] arr) {
        for (int x : arr) {
            out.print(x + " ");
        }
        out.println();
    }

    public static void setout(String fileName) {
        try {
            out = new PrintWriter(new FileOutputStream(fileName));
        } catch (IOException e) {
        }
    }

    static class Pair implements Comparable<Pair> {

        private int u;
        private int v;
        private int horse;
        private long w;

        Pair(int v, int horse, long w) {
            this.v = v;
            this.horse = horse;
            this.w = w;
        }

        Pair(int v, long w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Pair o) {
            return Long.compare(this.w, o.w);
            // return w-o.w;
        }
    }

    static class Reader {

        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException {
            din = new DataInputStream(
                    new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        private void fillBuffer() {
            try {
                bytesRead = din.read(buffer, bufferPointer = 0,
                        BUFFER_SIZE);
            } catch (IOException e) {
            }
            if (bytesRead == -1) {
                buffer[0] = -1;
            }
        }

        private byte read() {
            if (bufferPointer == bytesRead) {
                fillBuffer();
            }
            return buffer[bufferPointer++];
        }

        public String readLine() {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    } else {
                        continue;
                    }
                }
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg) {
                c = read();
            }
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg) {
                return -ret;
            }
            return ret;
        }

        public long nextLong() {
            long ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg) {
                c = read();
            }
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg) {
                return -ret;
            }
            return ret;
        }

        public double nextDouble() {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg) {
                c = read();
            }

            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg) {
                return -ret;
            }
            return ret;
        }

        public void close() throws IOException {
            if (din == null) {
                return;
            }
            din.close();
        }

        public int[] nextIntArray(int n, int start) {
            int[] arr = new int[n + start];
            for (int i = start; i < arr.length; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }

        public int[] nextIntArray(int n) {
            return nextIntArray(n, 0);
        }

    }

}

