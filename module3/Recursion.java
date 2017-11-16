public class Recursion {
  public static void main(String[] args) {

    System.out.println("For loop factorial for n = 4:");
    System.out.println(factorial(4));

    System.out.println("*************************\n");

    System.out.println("Recursion factorial for n = 4:");
    System.out.println(rec_factorial(4));

    System.out.println("*************************\n");

    System.out.println("Recursive Fibonacci for n = 6:");
    System.out.println(fibonacci(6));

    System.out.println("*************************\n");
  }

  public static int factorial(int n) {
    int result = 1;
    for (int i = 2; i <= n; i++) {
      result *= i;
    }
    return result;
  }

  public static int rec_factorial(int n) {
    if (n == 1) {
      return 1;
    } else {
      return n * rec_factorial(n-1);
    }
  }

  public static int fibonacci(int n) {
    if (n == 1) {
      return 1;
    } else if (n == 2) {
      return 1;
    } else {
      return fibonacci(n - 1) + fibonacci(n - 2);
    }
  }

}
