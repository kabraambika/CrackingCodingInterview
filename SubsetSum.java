import java.util.Arrays;

/**
 * Given a set of positive numbers arr and a value total,
 * determine if there exists a subset in the given set whose sum is equal to total.
 * A subset can be an empty set, or it can either consist of some elements of the set or all the elements of the set.
 * Let’s say you are given a set = {1, 2, 3, 7} and a total = 6.
 * The output will be TRUE as the subset = {1, 2, 3} adds up to make the desired total (1+2+3) = 6.
 */
public class SubsetSum {

  // driver code
  public static void main( String args[] ) {
    int[][] inputArr = {
        { 3, 5, 8 },
        { 2, 4, 7 },
        { 2, 3, 5 },
        { 1, 2, 3, 7 },
        { 10, 20, 23, 24 }
    };
    int[] total = { 13, 8, 5, 6, 57 };

    // You can uncomment the lines below and check how this recursive solution causes a time-out

    // int newInputArr[][] = Arrays.copyOf(inputArr, inputArr.length + 1);
    // newInputArr[inputArr.length] = new int[]{0, 1, 4, 6, 7, 8, 9, 10, 11, 16, 17, 18, 21, 23, 25, 26, 28, 34,
    //      35, 36, 38, 39, 40, 41, 42, 44, 47, 50, 51, 54, 55, 61, 62, 63, 65, 69, 71, 72,
    //      73, 75, 76, 78, 79, 80, 82, 83, 84, 85, 86, 88, 90, 91, 92, 93, 94, 98, 99, 100,
    //      101, 103, 104, 106, 109, 116, 118, 119};
    // inputArr = newInputArr;

    // int newTotal[] = Arrays.copyOf(total, total.length + 1);
    // newTotal[total.length] = 2593;
    // total = newTotal;


    String result = new String("");
    for (int i = 0; i < total.length; i++)
    {
      if (subsetSum(inputArr[i], total[i]))
        result = "Yes.";
      else
        result = "No.";
      System.out.println(i + 1 + ".\tDoes a subset of " + Arrays.toString(inputArr[i]) + " sum up to " + total[i] + "?  " + result);
      System.out.println(new String(new char[100]).replace('\0', '-'));
    }
  }

  public static boolean subsetSum(int[] arr, int total){
    int[][] dp = new int[arr.length+1][total+1];
    for(int[] row : dp){
      Arrays.fill(row, -1);
    }
    return subsetSumRec(arr, arr.length, total, dp) == 1;
  }

  private static int subsetSumRec(int[] arr, int n, int total, int[][] dp){
    if(total == 0){
      return 1;
    }
    if(n == 0){
      return 0;
    }

    if(dp[n][total] != -1){
      return dp[n][total];
    }

    if(arr[n-1] > total){
      dp[n][total] = subsetSumRec(arr, n-1, total, dp);
      return dp[n][total];
    }

    dp[n][total] = subsetSumRec(arr, n-1, total, dp) | subsetSumRec(arr, n-1, total - (arr[n-1]), dp);
    return dp[n][total];
  }

}

/**
 * Time complexity - O( n * m ) where n is the number of items and m is the total sum we need to achieve.
 * Space complexity - O ( n * m ) 
 */