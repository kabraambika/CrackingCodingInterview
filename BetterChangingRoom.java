import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class BetterChangingRoom {
  private final Set<Integer> allocatedRooms;
  private final Queue<Integer> availableRooms;
  private final PriorityQueue<Customer> waitingCustomers; // Priority queue for waiting customers
  private final int totalRooms;

  public BetterChangingRoom(int N) {
    this.totalRooms = N;
    this.allocatedRooms = new HashSet<>();
    this.availableRooms = new LinkedList<>();

    for(int roomNumber = 1; roomNumber < N; roomNumber++){
      availableRooms.offer(roomNumber);
    }

    this.waitingCustomers = new PriorityQueue<>((c1, c2) -> Integer.compare(c2.getPriority(), c1.getPriority()));
  }

  public synchronized int allocate(Customer customer) {
    if (!availableRooms.isEmpty()) {
      int allocatedRoom = availableRooms.poll(); // Get the first available room
      allocatedRooms.add(allocatedRoom);
      return allocatedRoom;
    } else {
      // No room available, add customer to waiting priority queue
      waitingCustomers.offer(customer);
      return -1; // Indicate that the customer is added to the waiting queue
    }
  }

  public synchronized void deallocate(int roomNumber) {
    if (!allocatedRooms.contains(roomNumber)) {
      throw new IllegalArgumentException("Room " + roomNumber + " is not currently allocated.");
    }
    allocatedRooms.remove(roomNumber);
    if (!waitingCustomers.isEmpty()) {
      // Allocate room to the next priority customer in the queue
      Customer nextCustomer = waitingCustomers.poll();
      notifyCustomer(nextCustomer, roomNumber); // Implement this method to notify the customer
    } else {
      availableRooms.offer(roomNumber); // Add back to available rooms
    }
  }

  public void notifyCustomer(Customer customer, int roomNumber) {
    System.out.println("Dear Customer " + customer.getId() + ", your room " + roomNumber + " is now ready for use.");
  }
}

class Customer {
  private int id;
  private int priority; // Higher values indicate higher priority

  public Customer(int id, int priority) {
    this.id = id;
    this.priority = priority;
  }

  public int getPriority() {
    return priority;
  }

  public int getId() {
    return id;
  }
}
