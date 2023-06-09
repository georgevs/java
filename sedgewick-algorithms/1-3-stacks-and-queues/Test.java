/*
  Build:
    javac -d ./bin/ ./*.java && java -cp ./bin/ Test
*/

public class Test {
  public static void main(String[] args) {
    testBag();
  }

  static void testBag() {
    var b = new Bag<Integer>();
    b.add(1);
    b.add(2);
    b.add(2);
    b.add(3);
    assert (b.size() == 3);
  }
}
