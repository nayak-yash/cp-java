package ds;

// works for 0 based indexing
public class PrefixSum {
    private final long[] prefixSum;
    private final int n;

    public PrefixSum(int[] arr) {
        n = arr.length;
        prefixSum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i - 1];
        }
    }

    public PrefixSum(long[] arr) {
        n = arr.length;
        prefixSum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i - 1];
        }
    }

    public long getSum(int l, int r) {
        return prefixSum[r + 1] - prefixSum[l];
    }

    public int lower_bound(int start, long target) {
        if (start >= n || getSum(start, n - 1) < target) return -1;
        int low = start, high = n - 1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (getSum(start, mid) < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public long[] getPrefixSum() {
        return prefixSum;
    }
}
