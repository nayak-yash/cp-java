package ds;

public class SegmentTree {
    private int[] tree;
    private int n;

    public SegmentTree(int[] arr) {
        this.n = arr.length;
        this.tree = new int[4 * n];
        build(arr, 0, n - 1, 0);
    }

    private void build(int[] arr, int start, int end, int index) {
        if (start == end) {
            tree[index] = arr[start];
            return;
        }
        int mid = (start + end) / 2;
        build(arr, start, mid, 2 * index + 1);
        build(arr, mid + 1, end, 2 * index + 2);
        tree[index] = tree[2 * index + 1] + tree[2 * index + 2];
    }

    public int query(int left, int right) {
        return queryUtil(0, n - 1, 0, left, right);
    }

    private int queryUtil(int start, int end, int index, int left, int right) {
        // Complete overlap
        if (left <= start && end <= right) {
            return tree[index];
        }
        // No overlap
        if (left > end || right < start) {
            return 0;
        }
        // Partial overlap
        int mid = (start + end) / 2;
        int leftQuery = queryUtil(start, mid, 2 * index + 1, left, right);
        int rightQuery = queryUtil(mid + 1, end, 2 * index + 2, left, right);
        return leftQuery + rightQuery;
    }

    public void update(int position, int value) {
        updateUtil(0, n - 1, 0, position, value);
    }

    private void updateUtil(int start, int end, int index, int position, int value) {
        if (start == end) {
            tree[index] = value;
            return;
        }
        int mid = (start + end) / 2;
        if (start <= position && position <= mid) updateUtil(start, mid, 2 * index + 1, position, value);
        else updateUtil(mid + 1, end, 2 * index + 2, position, value);
        tree[index] = tree[2 * index + 1] + tree[2 * index + 2];
    }
}
