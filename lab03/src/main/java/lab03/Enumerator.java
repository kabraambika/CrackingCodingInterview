package lab03;

/**
 * Interface for an enumerator over a list of strings.
 */
public interface Enumerator {

  /**
   * Does the enumerator have more strings to visit?
   * @return true if the enumerator has more strings; false otherwise.
   */
  public boolean hasNext();

  /**
   * Returns the next string in the underlying list.
   * @return string value
   * @throws IllegalStateException if the enumerator has reached the end of the list
   */
  public String getNext();
}
