/**
 * Longest palindrome substring
 *
 * refer https://leetcode.com/problems/longest-palindromic-substring/description/
 */
public class LongestPalindrome {
  public static void main(String[] args){
    String s = "babad";
    System.out.println("test case 1 babad: " + longestPalindrome(s));

    s = "cbbd";
    System.out.println("test case 2 cbbd: " + longestPalindrome(s));
  }
  public static String longestPalindrome(String s) {
    for(int length = s.length(); length > 0; length--){
      for(int start = 0; start <= s.length() - length; start++){
        if(check(start, start+length, s)){
          return s.substring(start, start+length);
        }
      }
    }
    return "";
  }

  private static boolean check(int i, int j, String s) {
    int left = i;
    int right = j - 1;

    while(left < right) {
      if(s.charAt(left) != s.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }
}
