import java.util.Scanner;

//The prime factors of 13195 are 5,7,13 and 29.
//
//What is the largest prime factor of a given number N?
public class EulerProblem3 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    for(int a0 = 0; a0 < t; a0++){
      long n = in.nextLong();
      short s = 9;
      System.out.println(getLargestPrimeFactor(n));
    }
  }
  private static long getLargestPrimeFactor(long n){
    long result = 1;

    while(n % 2 == 0){
      result = 2;
      n = n / 2;
    }


    for(long i = 3; i <= Math.sqrt(n); i+=2){
      while(n % i == 0){
        result = i;
        n = n / i;
      }
    }

    if( n > 2){
      result = n;
    }
    return result;
  }
}
