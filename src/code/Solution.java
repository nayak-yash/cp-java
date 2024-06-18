package code;

import utils.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

import static java.lang.Math.*;

class Solution {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final static PrintWriter out = new PrintWriter(System.out);
    private StringTokenizer st = new StringTokenizer("");
    private final Utils utils = new Utils();
    private final String TAG = "debug";
    private final int INT_MAX = Integer.MAX_VALUE;
    private final int INT_MIN = Integer.MIN_VALUE;
    private final long LONG_MAX = Long.MAX_VALUE;
    private final long LONG_MIN = Long.MIN_VALUE;
    private final int INF = 2000_000_000;
    private final long LONG_INF = 1000_000_000000000L;
    private final long MOD = 1000_000_007;

    private boolean multiCase = true;

    public void invoke() {
        int t = 1;
        if (multiCase) t = nextInt();
        while (t --> 0) {
            solve();
        }
        out.flush();
    }

    private void solve() {
        // write your code
    }

    public String next() {
        while (!st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return st.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    public char nextChar() {
        return next().charAt(0);
    }

    public int[] intArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = nextInt();
        return arr;
    }

    public int[][] intArray(int m, int n) {
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                arr[i][j] = nextInt();
        return arr;
    }

    public long[] longArray(int n) {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++)
            arr[i] = nextLong();
        return arr;
    }

    public long[][] longArray(int m, int n) {
        long[][] arr = new long[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                arr[i][j] = nextLong();
        return arr;
    }

    public double[] doubleArray(int n) {
        double[] arr = new double[n];
        for (int i = 0; i < n; i++)
            arr[i] = nextDouble();
        return arr;
    }

    public double[][] doubleArray(int m, int n) {
        double[][] arr = new double[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                arr[i][j] = nextDouble();
        return arr;
    }

    public char[] charArray(int n) {
        char[] arr = new char[n];
        for (int i = 0; i < n; i++)
            arr[i] = nextChar();
        return arr;
    }

    public char[][] charArray(int m, int n) {
        char[][] arr = new char[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                arr[i][j] = nextChar();
        return arr;
    }

    public String[] stringArray(int n) {
        String[] arr = new String[n];
        for (int i = 0; i < n; i++)
            arr[i] = next();
        return arr;
    }

    public String[][] stringArray(int m, int n) {
        String[][] arr = new String[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                arr[i][j] = next();
        return arr;
    }

    public void print(Object... str) {
        for (Object s : str)
            out.print(s + " ");
    }

    public void println(Object... str) {
        for (Object s : str)
            print(s);
        out.println();
    }

    public void debug(int[] arr) {
        for (int a : arr)
            print(a);
        println();
    }

    public void debug(long[] arr) {
        for (long a : arr)
            print(a);
        println();
    }

    public void debug(double[] arr) {
        for (double a : arr)
            print(a);
        println();
    }

    public void debug(char[] arr) {
        for (char a : arr)
            print(a);
        println();
    }

    public void debug(String[] arr) {
        for (String a : arr)
            print(a);
        println();
    }

    public void debug(int[][] arr) {
        for (int[] a : arr)
            debug(a);
        println();
    }

    public void debug(long[][] arr) {
        for (long[] a : arr)
            debug(a);
        println();
    }

    public void debug(double[][] arr) {
        for (double[] a : arr)
            debug(a);
        println();
    }

    public void debug(char[][] arr) {
        for (char[] a : arr)
            debug(a);
        println();
    }

    public void debug(String[][] arr) {
        for (String[] a : arr)
            debug(a);
        println();
    }

    public void debug(Object[] arr) {
        for (Object a : arr)
            print(a);
        println();
    }

    public void debug(Collection<Object> arr) {
        for (Object a : arr)
            print(a);
        println();
    }
}
