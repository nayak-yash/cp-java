package ds;

public class LazySegmentTree {
    private int[] tree;
    private int[] updates;
    private boolean[] isLazy;
    private int n;

    public LazySegmentTree(int[] arr) {
        this.n = arr.length;
        this.tree = new int[4 * n];
        this.updates = new int[4 * n];
        this.isLazy = new boolean[4 * n];
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
        push(index, start, end);
        int mid = (start + end) / 2;
        int leftQuery = queryUtil(start, mid, 2 * index + 1, left, right);
        int rightQuery = queryUtil(mid + 1, end, 2 * index + 2, left, right);
        return leftQuery + rightQuery;
    }

    public void update(int left, int right, int value) {
        updateUtil(0, n - 1, 0, left, right, value);
    }

    private void updateUtil(int start, int end, int index, int left, int right, int value) {
        // Complete overlap
        if (left <= start && end <= right) {
            propogate(index, left, right, value);
            return;
        }
        // No overlap
        if (left > end || right < start) {
            return;
        }
        // Partial overlap
        push(index, start, end);
        int mid = (start + end) / 2;
        updateUtil(start, mid, 2 * index + 1, left, right, value);
        updateUtil(mid + 1, end, 2 * index + 2, left, right, value);
        tree[index] = tree[2 * index + 1] + tree[2 * index + 2];
    }

    private void push(int index, int start, int end) {
        if (!isLazy[index]) return;
        isLazy[index] = false;
        int mid = (start + end) / 2;
        propogate(2 * index + 1, start, mid, updates[index]);
        propogate(2 * index + 2, mid + 1, end, updates[index]);
        updates[index] = 0;
    }

    private void propogate(int index, int start, int end, int val) {
        if (start != end) {
            isLazy[index] = true;
            updates[index] = val;
        }
        tree[index] = (end - start + 1) * val;
    }
}