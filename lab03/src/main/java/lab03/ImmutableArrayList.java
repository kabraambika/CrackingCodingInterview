package lab03;

import java.util.Arrays;

/**
 * An immutable list in which the elements are stored in an array.
 */
public class ImmutableArrayList implements ImmutableList {
  private final String[] elements;

  /**
   * Constructs a new ImmutableArrayList with the given elements.
   * @param elements The elements of the list.
   */
  public ImmutableArrayList(String... elements) {
    this.elements = Arrays.copyOf(elements, elements.length);
  }

  /**
   * Returns the number of strings in the list.
   * @return number of strings; guaranteed to not be negative.
   */
  public int size() {
    return elements.length;
  }

  /**
   * Returns the string at the indicated position in the list
   * @param index index of string to return; the first string is at index 0
   * @return the string at the given index
   * @throws IndexOutOfBoundsException if index is negative or past the end of the list
   */
  public String get(int index) {
    if (index < 0 || index >= elements.length) {
      throw new IndexOutOfBoundsException(index);
    } else {
      return elements[index];
    }
  }

  public Enumerator getEnumerator() {
    return new ImmutableArrayListEnumerator(this);
  }
}
