public class UnionFind {
    private final int[] parent;
    private final int[] size;

    UnionFind(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public void union(int x, int y) {
        int i = find(x);
        int j = find(y);
        if (i == j) {
            return;
        }

        if (size[x] < size[y]) {
            parent[x] = parent[y];
            size[y] += size[x];
        } else {
            parent[y] = parent[x];
            size[x] += size[y];
        }
    }

    private int find(int p) {
        while (parent[p] != p) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public boolean isConnected(int x, int y) {
        int m = find(x);
        int n = find(y);
        return m == n;
    }
}
