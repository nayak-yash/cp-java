package ds;

public class DisjointSet {
    public final int[] parent;
    public final int[] size;

    public DisjointSet(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int findParent(int u) {
        if (parent[u] == u) return u;
        return parent[u] = findParent(parent[u]);
    }

    public void union(int u, int v) {
        int uPar = findParent(u);
        int vPar = findParent(v);
        if (uPar == vPar) return;
        else if (size[uPar] > size[vPar]) {
            parent[vPar] = uPar;
            size[uPar] += size[vPar];
        } else {
            parent[uPar] = vPar;
            size[vPar] += size[uPar];
        }
    }

    public boolean isConnected(int u, int v) {
        return findParent(u) == findParent(v);
    }
}
