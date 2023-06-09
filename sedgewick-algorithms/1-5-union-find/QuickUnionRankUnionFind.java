import java.util.Arrays;
import java.util.Collections;

public class QuickUnionRankUnionFind implements UnionFind {
  private int[] rs;
  private int[] hs;

  public QuickUnionRankUnionFind(int n) {
    rs = new int[n];
    for (int i = 0; i < n; ++i) {
      rs[i] = i;
    }
    hs = new int[n];
    Collections.fill(Arrays.asList(hs), 1);
  }

  public boolean connected(int i, int j) {
    return find(i) == find(j);
  }

  public void union(int i, int j) {
    int ri = find(i), rj = find(j);
    if (ri != rj) {
      int hri = hs[ri], hrj = hs[rj];
      if (hri < hrj) {
        rs[ri] = rj;
      } else if (hrj < hri) {
        rs[rj] = ri;
      } else {
        rs[ri] = rj;
        ++hs[rj];
      }
    }
  }

  int find(int i) {
    while (i != rs[i]) {
      i = rs[i];
    }
    return i;
  }
}
