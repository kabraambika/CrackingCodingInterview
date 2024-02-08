/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively,
 * return the median of the two sorted arrays
 *
 * The overall run time complexity should be 0(log(m+n))
 * refer leetcode 4 https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 */
public class FindMedianSortedArrays {
  public static void main(String[] args){
    int[] nums1 = new int[] {1,3};
    int[] nums2 = new int[] {2};
    System.out.println("test case 1: " + findMedianSortedArrays(nums1, nums2));

    nums1 = new int[] {1,2};
    nums2 = new int[] {3,4};

    System.out.println("test case 2: " + findMedianSortedArrays(nums1, nums2));

  }
  /**
   * Approach : Binary search, recursive
   * Depending on total number of elements is odd or even, we need the kth (and maybe the (k+1)th element)
   * @param nums1 sorted array with size m
   * @param nums2 sorted array with size n
   * @return median of the two sorted arrays
   */
  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int n1 = nums1.length, n2 = nums2.length;
    int n = n1 + n2;

    if(n % 2 == 1){
      return solve(nums1, nums2, n/2, 0, n1 - 1, 0, n2 - 1);
    }
    else {
      return (double)(solve(nums1, nums2, n/2, 0, n1 - 1, 0, n2 - 1)
          + solve(nums1, nums2, n/2 - 1, 0, n1 -1, 0, n2 - 1)) / 2;
    }
  }

  private static int solve(int[] nums1, int[] nums2, int k, int aStart, int aEnd, int bStart, int bEnd) {
    if(aEnd < aStart){
      return nums2[k - aStart];
    }
    if(bEnd < bStart){
      return nums1[k - bStart];
    }

    int aIndex = (aStart + aEnd) / 2, bIndex = (bStart + bEnd) / 2;
    int aValue = nums1[aIndex], bValue = nums2[bIndex];

    if(aIndex + bIndex < k){
      if(aValue > bValue){
        return solve(nums1, nums2, k, aStart, aEnd, bIndex + 1, bEnd);
      }
      else {
        return solve(nums1, nums2, k, aIndex + 1, aEnd, bStart, bEnd);
      }
    }
    else {
      if(aValue > bValue){
        return solve(nums1, nums2, k, aStart, aIndex - 1, bStart, bEnd);
      }
      else {
        return solve(nums1, nums2, k, aStart, aEnd, bStart, bIndex - 1);
      }
    }
  }
}
