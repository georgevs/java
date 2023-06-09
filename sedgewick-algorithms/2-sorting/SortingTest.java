/*
  Build and run:
    javac -d ./bin/ -cp ../lib/* ./*.java && \
    java -cp ./bin/:../lib/* org.junit.runner.JUnitCore SortingTest
*/

import java.util.function.Consumer;
import java.util.function.Function;

import org.junit.Assert;
import org.junit.Test;

public class SortingTest {
  @Test
  public void testSelectionSort() {
    Assert.assertEquals(
        new Integer[] { 1, 2, 3, 3, 4 },
        selectionSort(new Integer[] { 1, 3, 4, 2, 3 }));

    Assert.assertEquals(
        new Integer[] { 1, 2, 3, 3, 4 },
        insertionSort(new Integer[] { 1, 3, 4, 2, 3 }));
  }

  // static <T extends Comparable<T>> void test(Consumer<T[]> sort) {
  //   Function<T[],T[]> fn = wrap(sort);
  //   Assert.assertEquals(
  //       new Integer[] { 1, 2, 3, 3, 4 },
  //       fn.apply(new Integer[] { 1, 3, 4, 2, 3 }));
  // }

  // static <T extends Comparable<T>> Function<T[],T[]> wrap(Consumer<T[]> sort) {
  //   return (xs) -> {
  //     sort.accept(xs);
  //     return xs;
  //   };
  // }

  public static void test(Consumer<? super Comparable<?>[]> sort) {
    Function<? super Comparable<?>[], ? extends Comparable<?>[]> fn = wrap(sort);
    Assert.assertArrayEquals(
        new Comparable[] { 1, 2, 3, 3, 4 },
        fn.apply(new Comparable[] { 1, 3, 4, 2, 3 }));
}

public static <T extends Comparable<T>> Function<T[], T[]> wrap(Consumer<T[]> sort) {
    return (xs) -> {
        sort.accept(xs);
        return xs;
    };
}

  static <T extends Comparable<T>> T[] selectionSort(T[] xs) {
    Selection.sort(xs);
    return xs;
  }

  static <T extends Comparable<T>> T[] insertionSort(T[] xs) {
    Insertion.sort(xs);
    return xs;
  }
}
