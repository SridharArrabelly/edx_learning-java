import java.util.Scanner;
import java.util.Arrays;

public class FractionCalculator {
  static Scanner input = new Scanner(System.in);
  static String[] VALID_OPERATIONS = {"+", "-", "/", "*", "=", "Q", "q"};

  public static void main(String[] args) {
    System.out.println("This program is a Fraction Calculator");
    System.out.println("It will add, subtract, multiply and divide fractions ultil you type Q to quit.");
    System.out.println("Please enter your fractions in the form a/b, where a and b are integers.");
    System.out.println("--------------------------------------------------------------------------------");

    // Get user input for desired operation
    String operation = getOperation();
    boolean quitProgram = false;
    if (operation.equals("Q") || operation.equals("q")) {
      quitProgram = true;
    }

    // Keep program running while user input is not Q or q
    while (!quitProgram) {
      operation = getOperation();
      if (operation.equals("Q") || operation.equals("q")) {
        quitProgram = true;
      }
      else {
        System.out.println("Reaching else");
      }
    }

  } // end main()


  public static String getOperation() {
    System.out.print("Please enter an operation (+, -, /, *, = or Q to quit): ");
    String operation = input.next();

    boolean inputContains = Arrays.stream(VALID_OPERATIONS).anyMatch(operation::equals);

    while (!inputContains) {
      System.out.print("Invalid Input (+, -, /, *, = or Q to quit): ");
      operation = input.next();
      inputContains = Arrays.stream(VALID_OPERATIONS).anyMatch(operation::equals);
    }

    return operation;
  } // end getOperation() method


  public static boolean validFraction(String fraction) {
    boolean isValid = true;
    return isValid;
  } // end validFraction() method


  public static Fraction getFraction(String scannerInput) {
    Fraction newFraction = new Fraction();
    return newFraction;
  } // end getFraction() method

} // end FractionCalculator Class
