package ds;

// works for 0 based indexing
public class PrefixXor {
    private final int[] prefixXor;
    private final int n;

    public PrefixXor(int[] arr) {
        n = arr.length;
        prefixXor = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixXor[i] = prefixXor[i - 1] ^ arr[i - 1];
        }
    }

    public int getXor(int l, int r) {
        return prefixXor[r + 1] ^ prefixXor[l];
    }

    public int[] getPrefixXor() {
        return prefixXor;
    }
}
