package lab03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ImmutableLinkedListTests {
  @Test
  public void testSize() {
    Assertions.assertEquals(0, new ImmutableLinkedList().size());
    Assertions.assertEquals(3, new ImmutableLinkedList("a", "b", "c").size());
  }

  @Test
  public void testGet() {
    ImmutableList l = new ImmutableLinkedList("x", "y", "z");

    try {
      Assertions.assertEquals("", l.get(-1));
      Assertions.fail("expected IndexOutOfBoundsException");
    } catch (IndexOutOfBoundsException e) {
      // NOP
    }

    try {
      Assertions.assertEquals("", l.get(3));
      Assertions.fail("expected IndexOutOfBoundsException");
    } catch (IndexOutOfBoundsException e) {
      // NOP
    }

    Assertions.assertEquals("x", l.get(0));
    Assertions.assertEquals("z", l.get(2));
  }

  @Test
  public void testEnumerator() {
    ImmutableList l = new ImmutableLinkedList("hello", "world!");
    Enumerator e = l.getEnumerator();

    Assertions.assertTrue(e.hasNext());
    Assertions.assertEquals("hello", e.getNext());
    Assertions.assertEquals("world!", e.getNext());
    Assertions.assertFalse(e.hasNext());
    try {
      Assertions.assertEquals("", e.getNext());
      Assertions.fail("expected IllegalStateException");
    } catch (IllegalStateException exn) {
      // NOP
    }
  }
}
