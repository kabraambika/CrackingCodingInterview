import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

interface LatencyInterface {
  int getMinLatency();
  int getMaxLatency();
  double getAvgLatency();
  double getMedianLatency();
  void addLatency(int latency);
  double getPercentile(double percentile);
}

class MedianHeap {
  private PriorityQueue<Integer> lowerHalf;
  private PriorityQueue<Integer> upperHalf;

  public MedianHeap() {
    this.lowerHalf = new PriorityQueue<>(Collections.reverseOrder());
    this.upperHalf = new PriorityQueue<>();
  }

  public void add(int number) {
    if(lowerHalf.isEmpty() || number <= lowerHalf.peek()) {
      lowerHalf.add(number);
    }
    else {
      upperHalf.add(number);
    }

    if(lowerHalf.size() > upperHalf.size() + 1) {
      upperHalf.add(lowerHalf.poll());
    }
    else if(upperHalf.size() > lowerHalf.size()) {
      lowerHalf.add(upperHalf.poll());
    }
  }

  public double getMedian() {
    if(lowerHalf.size() == upperHalf.size()) {
      return (lowerHalf.peek() + upperHalf.peek()) / 2.0;
    }
    else {
      return lowerHalf.peek();
    }
  }

  public List<Integer> getSortedElements() {
    List<Integer> sortedElements = new ArrayList<>(lowerHalf);
    sortedElements.addAll(upperHalf);
    Collections.sort(sortedElements);
    return sortedElements;
  }
}
public class LatencyStatsImpl implements LatencyInterface {
  private MedianHeap medianHeap;
  private int minLatency = Integer.MAX_VALUE;
  private int maxLatency = Integer.MIN_VALUE;
  private long totalSum;
  private int totalCount;

  public LatencyStatsImpl() {
    medianHeap = new MedianHeap();
  }

  @Override
  public int getMinLatency() {
    return minLatency;
  }

  @Override
  public int getMaxLatency() {
    return maxLatency;
  }

  @Override
  public double getAvgLatency() {
    return totalCount == 0 ? 0 : (double) totalSum / totalCount;
  }

  @Override
  public double getMedianLatency() {
    return medianHeap.getMedian();
  }

  @Override
  public void addLatency(int latency) {
    medianHeap.add(latency);
    minLatency = Math.min(minLatency, latency);
    maxLatency = Math.max(maxLatency, latency);
    totalSum += latency;
    totalCount++;
  }

  /**
   * time complexity - O(n log n)
   * @param percentile 99, 90
   * @return result in double
   */
  @Override
  public double getPercentile(double percentile) {
    List<Integer> sortedElements = medianHeap.getSortedElements();
    if(sortedElements.isEmpty()) {
      return 0;
    }

    int index = (int) Math.ceil(percentile / 100.0 * sortedElements.size()) - 1;
    return sortedElements.get(index);
  }
}
