import java.util.*;
public class MinimumPartitionArraySumDifferenceClass {
  // Driver Code
  public static void main(String[] args){

    int[][] inputs = {{5, 4, 4, 7, 2, 9}, {3, 25, 4, 12, 2}, {3, 7, 4, 12, 2},
        {1, 1, 1, 1000, 1}, {45, 2, 9, 87, 9, 12, 54, 56}};

    // You can uncomment the lines below and check how this recursive solution causes a time-out
    // int temp[][] = Arrays.copyOf(inputs, inputs.length + 1);
    // temp[inputs.length] = new int[]{28, 20, 19, 39, 51, 92, 41, 9, 79, 46,
    //                                 63, 77, 65, 10, 24, 5, 92, 2, 39, 68, 99, 60, 69, 88, 93, 99, 51, 44,
    //                                 67, 2, 90, 8, 9, 89, 48, 76, 58, 87, 77, 62, 22, 92, 86, 86, 46, 13,
    //                                 12, 75, 38, 77, 99, 6, 57, 71, 9, 23, 97, 80, 97, 69, 68, 28, 46, 16,
    //                                 25, 61, 80, 76, 35, 23, 8, 4, 19, 56, 58, 54, 77, 77, 41, 73, 95, 93,
    //                                 35, 70, 74, 90, 96, 46, 63, 32, 40, 32, 50, 2, 60, 73, 87, 61, 60, 42};
    // inputs = temp;

    for (int i = 0; i < inputs.length; i++){
      System.out.println(i + 1 + ".\tnums: " + Arrays.toString(inputs[i]) +
          "\n\n\tThe minimum difference in sums between the partitioned arrays is: " + minimumPartitionArraySumDifference(inputs[i]));

      //System.out.println(PrintHyphens.repeat("-", 100));
    }
  }

  private static int minimumPartitionArraySumDifference(int[] nums) {
    return 0;
  }
}
