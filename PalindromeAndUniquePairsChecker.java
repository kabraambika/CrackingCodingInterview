import java.util.*;
public class PalindromeAndUniquePairsChecker {
  public static void main(String[] args) {
    String input = "ababa"; // Example input

    boolean result = isPalindromeAndUniquePairs(input);
    System.out.println(input + " input and expected true, its result : " + result);

    String input1 = "notPalindrome"; // Example input

    boolean result1 = isPalindromeAndUniquePairs(input1);
    System.out.println(input1 + " input and expected false, its result : " + result1);

    String input2 = "hannah"; // Example input

    boolean result2 = isPalindromeAndUniquePairs(input2);
    System.out.println(input2 + " input and expected true, its result : " + result2);

    String input3 = "aabaa"; // Example input

    boolean result3 = isPalindromeAndUniquePairs(input3);
    System.out.println(input3 + " input and expected false, its result : " + result3);

    String input4 = "cectcec"; // Example input

    boolean result4 = isPalindromeAndUniquePairs(input4);
    System.out.println(input4 + " input and expected false, its result : " + result4);
  }

  private static boolean isPalindromeAndUniquePairs(String s) {
    if (isPalindrome(s)) {
      return !containsRepeatedPairs(s);
    } else {
      return false;
    }
  }

  private static boolean containsRepeatedPairs(String str) {
    Map<Character, Double> countMap = new HashMap<>();
    for (int i = 0; i < str.length(); i++) {
      Character c = str.charAt(i);
      countMap.put(c, countMap.getOrDefault(c, 0.0)+0.5);
    }

    List<Double> values = new ArrayList<>(countMap.values());
    for(Double v : values) {
      if(v > 1){
        return v % 1 == 0;
      }
    }
    return false; // No repeated pairs found
  }

  private static boolean isPalindrome(String str) {
    int left = 0;
    int right = str.length() - 1;
    while (left < right) {
      if (str.charAt(left) != str.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }
}
