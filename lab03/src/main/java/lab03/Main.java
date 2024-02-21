package lab03;

public class Main {
  public static void main(String[] args) {
    String[] elements = {"hi", "Ambika"};
    ImmutableLinkedList immutableLinkedList = new ImmutableLinkedList(elements);
    System.out.println(immutableLinkedList.getEnumerator());

    String[] otherElements = {"good", "bye"};
    ImmutableLinkedList immutableLinkedList2 = new ImmutableLinkedList(otherElements);
    System.out.println(immutableLinkedList2.getEnumerator());
  }
}
