import java.util.Scanner;
//<p>If we list all the natural numbers below $10$ that are multiples of $3$ or $5$, we get $3, 5, 6$ and $9$. The sum of these multiples is $23$.</p>
//<p>Find the sum of all the multiples of $3$ or $5$ below $1000$.</p>
public class EulerProblem1 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    for(int a0 = 0; a0 < t; a0++){
      int n = in.nextInt();

      System.out.println(helper(n));
    }
  }

  private static long helper(int limit){
    limit--;
    long sum = mult(limit, 3) + mult(limit, 5) - mult(limit, 15);
    return sum;
  }

  private static long mult(int n, int num){
    long quo = n / num;
    return num * quo * (quo+1) / 2;
  }
}
