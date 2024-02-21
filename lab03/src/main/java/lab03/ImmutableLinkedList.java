package lab03;

/**
 * An immutable list in which the values are stored in a linked list.
 */
public class ImmutableLinkedList implements ImmutableList {

  /**
   * The first node of the list; null if the list has no strings in it.
   */
  private final Node head;

  /**
   * Construct a new ImmutableLinkedList, containing the given elements
   * @param elements the elements of the list
   */
  public ImmutableLinkedList(String... elements) {
    Node node = null;
    for (int i = elements.length - 1; i >= 0; i--) {
      node = new Node(elements[i], node);
    }
    head = node;
  }

  /**
   * Returns the number of strings in the list.
   * @return number of strings; guaranteed to not be negative.
   */
  public int size() {
    int result = 0;
    for (Node n = head; n != null; n = n.getNext()) {
      result++;
    }

    return result;
  }

  /**
   * Returns the string at the indicated position in the list
   * @param index index of string to return; the first string is at index 0
   * @return the string at the given index
   * @throws IndexOutOfBoundsException if index is negative or past the end of the list
   */
  public String get(int index) {
    Node n = head;

    if (index < 0) {
      throw new IndexOutOfBoundsException(index);
    }

    for (int i = index; i > 0 && n != null; i--) {
      n = n.getNext();
    }
    if (n == null) {
      throw new IndexOutOfBoundsException(index);
    }

    return n.getValue();
  }

  /**
   * Get enumerator
   * @return instance of Enumerator
   */
  public Enumerator getEnumerator() {
    return new ImmutableLinkedListEnumerator(this);
  }

  /**
   * get head of ImmutableLinkedList
   * @return Node instance
   */
  public Node getHead() {
    return head;
  }

  @Override
  public String toString() {
    return "ImmutableLinkedList{" +
        "head=" + head +
        '}';
  }
}
