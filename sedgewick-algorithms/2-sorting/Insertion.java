public class Insertion {
  public static <T extends Comparable<T>> void sort(T[] xs) {
    int n = xs.length;
    for (int i = 1; i < n; ++i) {
      for (int j = i; 0 < j && xs[j].compareTo(xs[j - 1]) < 0; --j) {
        swap(xs, j - 1, j);
      }
    }
  }

  static <T extends Comparable<T>> void swap(T[] xs, int i, int j) {
    T t = xs[i];
    xs[i] = xs[j];
    xs[j] = t;
  };
}
