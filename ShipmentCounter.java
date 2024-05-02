public class ShipmentCounter {
  private static int[] weights;
  private static Integer[] memo;

  // Recursive function with memoization
  private static int findMaxBalancedShipments(int startIndex) {
    if (startIndex >= weights.length) return 0; // Base case
    if (memo[startIndex] != null) return memo[startIndex]; // Use memoized result

    int maxShipments = 0;
    int maxWeight = weights[startIndex];
    for (int end = startIndex; end < weights.length; end++) {
      maxWeight = Math.max(maxWeight, weights[end]);
      if (weights[end] < maxWeight) { // Check if balanced
        maxShipments = Math.max(maxShipments, 1 + findMaxBalancedShipments(end + 1));
      }
    }

    memo[startIndex] = maxShipments; // Memoize result
    return maxShipments;
  }

  public static int findMaximumBalancedShipments(int[] inputWeights) {
    weights = inputWeights;
    memo = new Integer[weights.length];
    return findMaxBalancedShipments(0); // Start from the first parcel
  }

  public static void main(String[] args) {
    int[] weights = {8, 5, 4, 7, 2};
    int[] weights1 = {1, 2, 3, 2, 6, 3};
    int[] weights2 = {3,9,4,7};
    int[] weights3 = {8, 5, 4, 7, 2};
    int[] weights4 = {4,3,6,5,3,4,7,1};
        //{10,5,6,4,7,6,4,2,7,1,4,6,3,4,5,1,7,5,4,6,7,8,4,6,1,9,9};

    System.out.println("Max balanced shipment: " + findMaximumBalancedShipments(weights)); // Expected output: 2
    System.out.println("Max balanced shipment: " + findMaximumBalancedShipments(weights1)); // Expected output: 2
    System.out.println("Max balanced shipment: " + findMaximumBalancedShipments(weights2)); // Expected output: 1
    System.out.println("Max balanced shipment: " + findMaximumBalancedShipments(weights3)); // Expected output: 2
    System.out.println("Max balanced shipment: " + findMaximumBalancedShipments(weights4)); // Expected output: 3
  }
}

