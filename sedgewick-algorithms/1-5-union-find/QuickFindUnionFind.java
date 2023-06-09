public class QuickFindUnionFind implements UnionFind {
  private int[] rs;

  public QuickFindUnionFind(int n) {
    rs = new int[n];
    for (int i = 0; i < n; ++i) {
      rs[i] = i;
    }
  }

  public boolean connected(int i, int j) {
    return rs[i] == rs[j];
  }

  public void union(int i, int j) {
    if (rs[i] != rs[j]) {
      for (int k = 0; k < rs.length; ++k) {
        if (rs[k] == i) {
          rs[k] = j;
        }
      }
    }
  }
}
