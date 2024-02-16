package lab03;

/**
 * ImmutableLinkedListEnumerator class implements Enumerator
 */
public class ImmutableLinkedListEnumerator implements Enumerator {
  private final ImmutableLinkedList list;
  private Node currentNode;

  /**
   * constructor of ImmutableLinkedListEnumerator
   * @param list instance of ImmutableLinkedList
   */
  public ImmutableLinkedListEnumerator(ImmutableLinkedList list) {
    this.list = list;
    this.currentNode = list.getHead();
  }

  @Override
  public boolean hasNext() {
    return currentNode != null;
  }

  @Override
  public String getNext() {
    if (!hasNext()) {
      throw new IllegalStateException();
    }
    String nextElement = currentNode.getValue();
    currentNode = currentNode.getNext();
    return nextElement;
  }
}