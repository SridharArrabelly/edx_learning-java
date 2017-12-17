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
    String operation;
    String userFraction;
    boolean quitProgram = false;
    boolean testEquality;

    // Keep program running while user input is not Q or q
    while (!quitProgram) {
      operation = getOperation();
      if (operation.equals("Q") || operation.equals("q")) {
        quitProgram = true;
        System.out.println("See you soon...");
      }
      else {
        Fraction newFraction;
        System.out.print("Please enter a fraction 'a/b' or integer 'a': ");
        userFraction = input.next();
        Fraction fraction1 = getFraction(userFraction);

        System.out.print("Please enter a fraction 'a/b' or integer 'a': ");
        userFraction = input.next();
        Fraction fraction2 = getFraction(userFraction);

        // Performing operation on user fractions
        if (operation.equals("+")) {
          newFraction = fraction1.add(fraction2);
        }
        else if (operation.equals("-")) {
          newFraction = fraction1.subtraction(fraction2);
        }
        else if (operation.equals("/")) {
          newFraction = fraction1.divide(fraction2);
        }
        else if (operation.equals("*")) {
          newFraction = fraction1.multiply(fraction2);
        }
        else {
          testEquality = fraction1.equals(fraction2);
          System.out.println(fraction1.toString() + " = " + fraction2.toString() + " is " + testEquality);
          continue;
        }

        newFraction.toLowestTerms();
        System.out.println(fraction1.toString() + " " + operation + " " + fraction2.toString() + " = " + newFraction.toString());

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


  // Use Integer.parseInt and excpetion handling
  // to verify if the given string is a number or not.
  public static boolean isNumber(String number) {
    try {
      int intNumber = Integer.parseInt(number);
      return true;
    }
    catch (NumberFormatException e) {
      return false;
    }
  }


  // Test if the string have a valid fraction format
  // e.g.: "a/b" or "-a/b" or "a/-b" or "-a/-b" or "a" or ""
  // "a" and "b" must be integers
  public static boolean validFraction(String userInput) {
    String[] splittedString = userInput.split("/");

    if (splittedString.length > 2) {
      return false;
    }
    else if (splittedString.length == 2) {
      if (isNumber(splittedString[0]) && isNumber(splittedString[1])) {
        if (Integer.parseInt(splittedString[1]) != 0) {
          return true;
        }
      }
      else {
        return false;
      }
    }
    else {
      if (isNumber(splittedString[0])) {
        return true;
      }
      else if (splittedString[0].equals("")) {
        return true;
      }
      else {
        return false;
      }
    }
    return false;
  } // end validFraction() method


  public static Fraction getFraction(String userInput) {
    int numerator;
    String[] splittedString;
    Fraction fraction;

    while (!validFraction(userInput)) {
      System.out.print("Invalid Fraction. Please enter (a/b) or (a), where a and b are integers and b is not zero: ");
      userInput = input.next();
    }

    splittedString = userInput.split("/");

    if (splittedString.length == 2) {
      numerator = Integer.parseInt(splittedString[0]);
      int denominator = Integer.parseInt(splittedString[1]);
      fraction = new Fraction(numerator, denominator);
    }
    else if (splittedString.length == 1) {
      numerator = Integer.parseInt(splittedString[0]);
      fraction = new Fraction(numerator);
    }
    else {
      fraction = new Fraction();
    }

    return fraction;
  } // end getFraction() method

} // end FractionCalculator Class
