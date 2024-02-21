package lab03;

/**
 * A single node in an ImmutableLinkedList.
 */
public class Node {

  /**
   * The string stored at this node.
   */
  private final String value;

  /**
   * The next node in the list.
   */
  private final Node next;

  /**
   * Construct a node.
   *
   * @param value value to store at this node
   * @param next the node's successor in the list.
   */
  public Node(String value, Node next) {
    this.value = value;
    this.next = next;
  }

  /**
   * Get the value.
   * @return the value in this node
   */
  public String getValue() { return value; }

  /**
   * Get the node's successor
   * @return node's successor
   */
  public Node getNext() { return this.next; }

  @Override
  public String toString() {
    return "Node{" +
        "value='" + value + '\'' +
        ", next=" + next +
        '}';
  }
}
