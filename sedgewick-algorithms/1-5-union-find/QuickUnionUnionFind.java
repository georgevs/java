public class QuickUnionUnionFind implements UnionFind {
  private int[] rs;

  public QuickUnionUnionFind(int n) {
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
    while (i != rs[i]) {
      i = rs[i];
    }
    return i;
  }
}
