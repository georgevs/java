public class Selection {
  public static <T extends Comparable<T>> void sort(T[] xs) {
    int n = xs.length;
    for (int i = 0; i + 1 < n; ++i) {
      swap(xs, i, min(xs, i, n));
    }
  }

  static <T extends Comparable<T>> int min(T[] xs, int i, int e) {
    int k = i;
    for (++i; i < e; ++i) {
      if (xs[i].compareTo(xs[k]) < 0) {
        k = i;
      }
    }
    return k;
  }

  static <T extends Comparable<T>> void swap(T[] xs, int i, int j) {
    T t = xs[i];
    xs[i] = xs[j];
    xs[j] = t;
  };
}
