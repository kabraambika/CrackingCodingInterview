import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

//Initial solution for resource management question
public class ChangingRoomManager {
  private int totalRooms;
  private Set<Integer> allocatedRooms;

  //The use of a PriorityQueue for available rooms ensures that the room with the lowest number is always allocated first, following the requirement.
  private PriorityQueue<Integer> availableRooms;

  public ChangingRoomManager(int totalRooms) {
    this.totalRooms = totalRooms;
    this.allocatedRooms = new HashSet<>();
    this.availableRooms = new PriorityQueue<>();

    for(int i = 1; i <= totalRooms; i++){
      availableRooms.offer(i);
    }
  }

  /**
   * This method checks if there are any available rooms by checking the availableRooms queue.
   * If available, it removes a room from the queue (which automatically selects the room
   * with the lowest number due to the nature of PriorityQueue),
   * adds it to the allocatedRooms set to mark it as allocated, and returns the room number.
   * This method is synchronized to ensure thread safety
   * when multiple threads are trying to allocate rooms simultaneously.
   * @return the room number.
   */
  public synchronized int allocate() {
    if(availableRooms.isEmpty()) {
      throw new IllegalStateException("No available rooms");
    }

    int allocatedRoom = availableRooms.poll();
    allocatedRooms.add(allocatedRoom);
    return allocatedRoom;
  }

  /**
   * This method takes a room number as input and checks if the room is currently
   * allocated by looking it up in the allocatedRooms set.
   * If the room is indeed allocated, it removes it from the set and
   * adds it back to the availableRooms queue, making it available for future allocations.
   * This method is also synchronized to ensure thread safety during concurrent deallocations.
   * @param roomNumber the room number
   */
  public synchronized void deallocate(int roomNumber){
    if(!allocatedRooms.contains(roomNumber)){
      throw new IllegalStateException("Room " + roomNumber + " is not currently allocated.");
    }

    allocatedRooms.remove(roomNumber);
    availableRooms.offer(roomNumber);
  }
}
