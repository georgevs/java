public class QuickUnionCompressPathUnionFind implements UnionFind {
  private int[] rs;

  public QuickUnionCompressPathUnionFind(int n) {
    rs = new int[n];
    for (int i = 0; i < n; ++i) {
      rs[i] = i;
    }
  }

  public boolean connected(int i, int j) {
    return find(i) == find(j);
  }

  public void union(int i, int j) {
    int ri = find(i), rj = find(j);
    if (ri != rj) {
      rs[i] = j;
    }
  }

  int find(int i) {
    if (i != rs[i]) {
      i = rs[i] = find(rs[i]);
    }
    return i;
  }
}
