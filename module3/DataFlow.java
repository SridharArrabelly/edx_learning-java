import java.util.Scanner;

public class DataFlow {
  public static void main(String[] args) {
    System.out.println("Methods with parameters: ");
    for (double i = 0; i <= 3; i++) {
      power(i, i * 1.5);
    }
    System.out.println("");

    for (int i = 0; i <= 3; i++) {
      power(i, i * 2);
    }

    System.out.println("******************************\n");

    System.out.println("Methods returning:");
    int x = return_power(2, 3);
    System.out.println("The method returned " + x);

    System.out.println("");

    Scanner input = new Scanner(System.in);
    System.out.print("What's your name? ");
    String name = input.next();

    String new_name = get_name(name);
    System.out.println("Now your name is " + new_name);

    System.out.println("******************************\n");

    System.out.println("String methods:");
    String test = "abcde";
    System.out.println("My string is: " + test + "\n");
    System.out.println("My string has length: " + test.length());
    System.out.println("Heres a substring of my string: " + test.substring(1,3));
    System.out.println("The index of letter d in my string is: " + test.indexOf("d"));
    System.out.println("The index of letter D in my string is: " + test.indexOf("D") + ". It's not in the string.");
    // Transforming my string to capital letters
    test = test.toUpperCase();
    System.out.println("Transforming my string to capital letters...");
    System.out.println("The index of letter D in my string is: " + test.indexOf("D"));
    System.out.println("******************************\n");
  }

  // Two methods with the same name and
  // different signatures.
  public static void power(int base, int exp) {
    int result = 1;
    for (int i = 0; i <= exp; i++) {
      result *= base;
    }
  System.out.println("Base " + base + " to the exp " + exp + " = " + result);
  }

  public static void power(double base, double exp) {
    double result = 1;
    for (int i = 1; i <= exp; i++) {
      result *= base;
    }
  System.out.println("Base " + base + " to the exp " + exp + " = " + result);
  }

  // Methods with parameters and returning values.
  public static int return_power(int x, int y) {
    int result = 1;
    for (int i = 1; i <= y; i++) {
      result *= x;
    }
    return result;
  }

  public static String get_name(String name) {
    name = name + " " + "Foo Bar";
    return name;
  }
}
