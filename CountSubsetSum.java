import java.util.Arrays;
/**
 * Given a set of positive numbers nums and a value targetSum,
 * count the total number of subsets of the given set whose sum is equal to the targetSum.
 * Let say you are given a set = {1,2,3,4} and a target sum = 4. the output is 2 as the following subset : {1,3}, {4}
 * Space complexity : O(n ∗ s)
 * time complexity of this approach is reduced to O(n ∗ s), where n is the number of elements and s is the target sum.
 */
public class CountSubsetSum {
  // Driver code
  public static void main(String[] args) {
    int[][] inputNums = {
        { 1 },
        { 11, 33 },
        { 4, 2, 3 },
        { 1, 4, 2, 3 },
        { 1, 2, 7, 4, 5 },
        { 1, 2, 3, 7 }
    };
    int[] targetSums = { 10, 11, 6, 4, 9, 6 };

    // You can uncomment the lines below and check how this recursive solution causes a time-out
    // int newInputNums[][] = Arrays.copyOf(inputNums, inputNums.length + 1);
    // newInputNums[inputNums.length] = new int[]{1, 4, 6, 7, 8, 9, 10, 11, 16, 17, 18, 21,
    //     23, 25, 26, 28, 34, 35, 36, 38, 39, 40, 41, 42, 44, 47, 50,
    //     51, 54, 55, 61, 62, 63, 65, 69, 71, 72, 73, 75, 76, 78, 79,
    //     80, 82, 83, 84, 85, 86, 88, 90, 91, 92, 93, 94, 98, 99, 100,
    //     101, 103, 104, 106, 109, 116, 118, 119};
    // inputNums = newInputNums;

    // int newTargetSums[] = Arrays.copyOf(targetSums, targetSums.length + 1);
    // newTargetSums[targetSums.length] = 2593;
    // targetSums = newTargetSums;

    int index = 0;
    for (int [] input: inputNums) {
      System.out.println((index + 1) + ".\tnums = " + Arrays.toString(input));
      System.out.println("\ttarget sum = " + targetSums[index]);
      System.out.println("\tTotal number of subsets whose sum is equal to the target sum = " + countSubsetSum(input, targetSums[index]));
      System.out.println(new String(new char[100]).replace('\0', '-'));
      index++;
    }
  }

  private static long countSubsetSum(int[] nums, int targetSum) {
    long[][] dp = new long[nums.length][targetSum+1];
    for(long[] row : dp){
      Arrays.fill(row, -1);
    }

    return countSubsetSumRec(nums, targetSum, 0, dp);
  }

  private static long countSubsetSumRec(int[] nums, int targetSum, int index, long[][] dp) {
    if(targetSum == 0){
      return 1;
    }

    if(index >= nums.length){
      return 0;
    }

    if(dp[index][targetSum] == -1){
      long sum1 = 0;
      if(nums[index] <= targetSum){
        sum1 = countSubsetSumRec(nums, targetSum - nums[index], index+1, dp);
      }
      long sum2 = countSubsetSumRec(nums, targetSum, index+1, dp);
      dp[index][targetSum] = sum1 + sum2;
    }
    return dp[index][targetSum];
  }
}

