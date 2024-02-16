package lab03;

/**
 * An immutable list of strings.  Immutable, in this case, means that it is not possible
 * to change the list once it has been created.
 */
public interface ImmutableList {

  /**
   * Returns the number of strings in the list.
   * @return number of strings; guaranteed to not be negative.
   */
  int size();

  /**
   * Returns the string at the indicated position in the list
   * @param index index of string to return; the first string is at index 0
   * @return the string at the given index
   * @throws IndexOutOfBoundsException if index is negative or past the end of the list
   */
  String get(int index);

  /**
   * Create an enumerator that returns each of the elements in this list, in order.
   * @return new enumerator.
   */
  Enumerator getEnumerator();
}
