import java.util.Arrays;

/**
 * Given an array of positive integers, arr, and a target, T,
 * build an expression using these numbers by inserting a
 * + or a − before each integer, and evaluating this expression.
 * Find the total number of different expressions that evaluate to T.
 */
public class TargetSum {
  // Driver code
  public static void main(String args[] ) {
    int[][] arrs = {{1}, {3, 3, 3, 3}, {2, 3, 4, 6, 8, 12}, {2, 2, 2, 4, 4, 4, 8, 8, 8}};
    int[] targets = {1, 6, 15, 18};

    // Let's uncomment this to see the benefit of using dynamic programming with tabulation

    // int newArrs[][] = Arrays.copyOf(arrs, arrs.length + 1);
    // newArrs[arrs.length] = new int[]{2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3};
    // arrs = newArrs;

    // int newTargets[] = Arrays.copyOf(targets, targets.length + 1);
    // newTargets[targets.length] = 42;
    // targets = newTargets;

    for (int i=0; i<arrs.length; ++i){
      String a =  "[" + arrs[i][0];
      for (int j=1; j<arrs[i].length; ++j)
        a = a + ", " + arrs[i][j];
      a += "]";
      System.out.println(i + 1 + ".\t Input array: " + a);
      System.out.println("\t Target: " + targets[i]);
      System.out.println("\t Number of ways in which we can find the target sum: " + findTargetSum(arrs[i], targets[i]));
      System.out.println(new String(new char[100]).replace('\0', '-'));
    }
  }
 public static int findTargetSum(int[] arr, int target){
    int total = 0;
    for(int num : arr){
      total += num;
    }

    if(total < Math.abs(target)){
      return 0;
    }

    int[][] dp = new int[arr.length][2*total+1];
    for(int[] row : dp){
      Arrays.fill(row, -1);
    }

    return findTargetSumRec(arr, target, total, 0, 0, dp);
 }

 private static int findTargetSumRec(int[] arr, int target, int total, int i, int sum, int[][] dp){
    if(i == arr.length){
      if(sum == target){
        return 1;
      }
      return 0;
    }
    if(dp[i][sum+total] != -1){
      return dp[i][sum+total];
    }

    dp[i][sum+total] = findTargetSumRec(arr, target, total, i+1, sum-arr[i], dp) + findTargetSumRec(arr, target, total, i+1, sum+arr[i], dp);

    return dp[i][sum+total];
 }
}

/**
 * Time complexity
 * the time complexity of this approach is reduced to O ( n * k ) where n is the size of the array
 * and k = sum(arr)
 * Space complexity : the space taken by the lookup table is O ( n * k) where n is the size of the array
 * and k = sum(arr)
 */