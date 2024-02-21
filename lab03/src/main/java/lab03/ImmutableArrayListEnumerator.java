package lab03;

/**
 * ImmutableArrayListEnumerator class implements Enumerator
 */
public class ImmutableArrayListEnumerator implements Enumerator {
  private final ImmutableArrayList list;
  private int currentPosition;

  /**
   * Constructor of ImmutableArrayListEnumerator
   * @param list instance of ImmutableArrayList
   */
  public ImmutableArrayListEnumerator(ImmutableArrayList list) {
    this.list = list;
    this.currentPosition = 0;
  }

  @Override
  public boolean hasNext() {
    return currentPosition < list.size();
  }

  @Override
  public String getNext() {
    if (!hasNext()) {
      throw new IllegalStateException();
    }
    String nextElement = list.get(currentPosition);
    currentPosition++;
    return nextElement;
  }

  @Override
  public String toString() {
    return "ImmutableArrayListEnumerator{" +
        "list=" + list +
        ", currentPosition=" + currentPosition +
        '}';
  }
}
