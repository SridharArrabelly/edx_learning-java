/*
 Objected Oriented Programming in Java
 Title: Module 2 Project - Fraction Calculator
 File: FractionCalculatorAdvanced.java
 Author: Claudio Castello
 GitHub: http://github.com/claudiocastello
 email: floggio.dev@gmail.com

 This class differs from FractionCalculator in the sense
 that it allows users to enter fractions and operations
 in one line in the form [fraction] [operation] [fraction].
 */

 import java.util.Arrays;
 import java.io.InputStreamReader;
 import java.io.BufferedReader;

class AdvancedFractionCalculator {
  // Declaration of InputStreamReader, BufferedReader
  // objects and VALID_OPERATIONS string array.
  static InputStreamReader stremReader = new InputStreamReader(System.in);
  static BufferedReader input = new BufferedReader(stremReader);
  static String[] VALID_OPERATIONS = {"+", "-", "/", "*", "=", "Q", "q"};

  public static void main(String[] args) throws Exception {
    // Get user input for desired operation
    String singleLine;
    boolean quitProgram = false, testEquality;

    System.out.println("This program is a Fraction Calculator");
    System.out.println("It will add, subtract, multiply and divide fractions ultil you type Q to quit.");
    System.out.println("----------------------------------------------------------------------------------");


    // Keep program running while user input is not Q or q
    while (!quitProgram) {
      // Ask for user input
      singleLine = getInput();
      if (singleLine.equals("Q") || singleLine.equals("q")) {
        // If user input Q or q, quit program.
        quitProgram = true;
        System.out.println("See you soon...");
      }
      else {
        try {
          String[] splittedString = singleLine.split(" ");

          // Get fraction in splittedString[0], fraction in splittedString[2]
          // and performs the operation in splittedString[1].
          Fraction fraction1, fraction2, newFraction;
          String operation = splittedString[1];

          fraction1 = getFraction(splittedString[0]);
          fraction2 = getFraction(splittedString[2]);

          // Performs operation on user fractions
          // Look for the four basic operations...
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
          // If not found, test for fraction equality
          else {
            testEquality = fraction1.equals(fraction2);
            System.out.println(fraction1.toString() + " = " + fraction2.toString() + " is " + testEquality);
            continue;
          }

          newFraction.toLowestTerms();
          System.out.println(fraction1.toString() + " " + operation + " " + fraction2.toString() + " = " + newFraction.toString());
        } // end try
        
        // If excpetion raised...
        catch (IllegalArgumentException e) {
          System.out.println("Invalid fraction. Denominator can't be zero.");
        }
      } // end else
    } // end while loop

    input.close();
    stremReader.close();
  } // end main()


  // Get user input in a single sline and test for valid fracitions
  // and valid operations.
  public static String getInput() throws Exception {
    System.out.println("Insert input [fraction] [operation] [fraction] o Q to quit:");
    String singleLine = input.readLine();

    while (!validLine(singleLine)) {
      System.out.println("Invalid input! Insert [Fraction] [Operation] [Fraction]: ");
      singleLine = input.readLine();
    }

    return singleLine;
  }


  // Check if the line inserted by user has the valid
  // format [Fraction] [Operation] [Fraction]
  public static boolean validLine (String userInput) {
    String[] splittedString = userInput.split(" ");

    if (userInput.equals("Q") || userInput.equals("q")) {
      // Test if user wants to quit program and return true in this case
      return true;
    }

    if (splittedString.length != 3) {
      /*
        If the length of the String Array is different from three it
        means that there's more than one ' ' substring. Or there is
        not enough terms in the line to caracterize the valid format.
        It's not a valid fraction! For example:
        a/b + c/d --> valid
        a/ b + c/d --> not valid
        a/b + b/c * e --> not valid
      */
      return false;
    }
    else if (!validOperation(splittedString[1])) {
      return false;
    }
    else if (!validFraction(splittedString[0])) {
      return false;
    }
    else if (!validFraction(splittedString[2])) {
      return false;
    }
    else {
      return true;
    }
  } // end validLine() method


  // Check if the operation is valid comparing with
  // the VALID_OPERATIONS constant.
  public static boolean validOperation(String operation) {
    boolean inputContains = Arrays.stream(VALID_OPERATIONS).anyMatch(operation::equals);
    return inputContains;
  }


  // Use Integer.parseInt and excpetion handling
  // to verify if the given string is a number or not.
  public static boolean isNumber(String number) {
    try {
      // Try to convert the string to int
      // and return true if it is possible.
      int intNumber = Integer.parseInt(number);
      return true;
    }
    // If excpetion raised, return false.
    catch (NumberFormatException e) {
      return false;
    }
  }


  // Test if the string have a valid fraction format
  // e.g.: "a/b" or "-a/b" or "a/-b" or "-a/-b" or "a" or ""
  // "a" and "b" must be integers
  public static boolean validFraction(String userInput) {
    // Split the string into an Array of strings
    // based on the '/' sign.
    String[] splittedString = userInput.split("/");

    if (splittedString.length > 2) {
      // If the length of the String Array is
      // greater than two it means that there's
      // more than one '/' sign. It's not a valid
      // fraction.
      return false;
    }
    else if (splittedString.length == 2) {
      // If the length of the String Array is equal 2,
      // it means that users have entered a String
      // in the format a/b.
      if (isNumber(splittedString[0]) && isNumber(splittedString[1])) {
        //Test if 'a' and 'b' are valid numbers.
        if (Integer.parseInt(splittedString[1]) != 0) {
          // Simply test if 'b' is not zero.
          return true;
        }
      }
      else {
        return false;
      }
    }
    else {
      // If the String Array length is not 2 it must
      // be 1 and is a String representing an Integer,
      // an empty String or an invalid String.
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


  // Method to get a String input and build a Fraction object.
  public static Fraction getFraction(String userInput) throws Exception {
    int numerator, denominator;
    String[] splittedString;
    Fraction fraction = new Fraction();

    while (!validFraction(userInput)) {
      // Test for a valid input from users based on the rules
      // of validFraction method. Keep asking until a valid
      // input is inserted.
      System.out.print("Invalid Fraction. Please enter (a/b) or (a), where a and b are integers and b is not zero: ");
      userInput = input.readLine();
    }

    // Split the valid input to build the Fraction object.
    splittedString = userInput.split("/");

    // For fractions with '/' delimiter the length will
    // be equal 2. Convert strings to int's numerator and
    // denominator and initialize the Fraction object.
    if (splittedString.length == 2) {
      numerator = Integer.parseInt(splittedString[0]);
      denominator = Integer.parseInt(splittedString[1]);
      fraction = new Fraction(numerator, denominator);
    }

    // If entered string has the 'a' format and is not empty,
    // convert it to int and build the Fraction object.
    else if (splittedString.length == 1 &&
             !splittedString[0].equals("")) {
      numerator = Integer.parseInt(splittedString[0]);
      fraction = new Fraction(numerator);
    }

    // For empty strings, just return the pre-initialized
    // Fraction object Fraction() -> 0/1.
    else {
      return fraction;
    }
    return fraction;
  } // end getFraction() method

} // end AdvancedFractionCalculator class
