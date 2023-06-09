import java.util.HashSet;

public class Bag<Item> {
  private HashSet<Item> s;

  public Bag() {
    s = new HashSet<>();
  }

  void add(Item x) {
    s.add(x);
  }

  int size() {
    return s.size();
  }
}
