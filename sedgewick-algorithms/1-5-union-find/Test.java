/*
  Build:
    javac -d ./bin/ ./*.java && java -cp ./bin/ Test
*/

import java.util.function.Function;

public class Test {
  public static void main(String[] args) {
    test(QuickFindUnionFind::new);
    test(QuickUnionUnionFind::new);
    test(QuickUnionCompressPathUnionFind::new);
  }

  static <T extends UnionFind> void test(Function<Integer, T> ctor) {
    var n = 10;
    var u = ctor.apply(n);

    for (int i = 0; i < n; ++i) {
      assert (u.connected(i, i));
      for (int j = i + 1; j < n; ++j) {
        assert (!u.connected(i, j));
      }
    }

    u.union(1, 2);
    u.union(2, 5);
    u.union(5, 6);
    u.union(6, 7);
    u.union(3, 8);

    assert (u.connected(1, 5));
    assert (u.connected(5, 7));

    assert (!u.connected(4, 9));
    u.union(9, 4);
    assert (u.connected(4, 9));
  }
}
