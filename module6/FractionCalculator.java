/*
 Objected Oriented Programming in Java
 Title: Module 2 Project - Fraction Calculator
 File: FractionCalculator.java
 Author: Claudio Castello
 GitHub: http://github.com/claudiocastello
 email: floggio.dev@gmail.com
 */

import java.util.Arrays;
import java.io.*;

public class FractionCalculator {
  // Declaration of InputStreamReader, BufferedReader
  // objects and VALID_OPERATIONS string array.
  static InputStreamReader stremReader = new InputStreamReader(System.in);
  static BufferedReader input = new BufferedReader(stremReader);
  static String[] VALID_OPERATIONS = {"+", "-", "/", "*", "=", "Q", "q"};

  public static void main(String[] args) throws Exception {
    System.out.println("This program is a Fraction Calculator");
    System.out.println("It will add, subtract, multiply and divide fractions ultil you type Q to quit.");
    System.out.println("Please enter your fractions in the form a/b, where a and b are integers.");
    System.out.println("--------------------------------------------------------------------------------");

    // Get user input for desired operation
    String operation, userFraction1, userFraction2;
    boolean quitProgram = false, testEquality;

    // Keep program running while user input is not Q or q
    while (!quitProgram) {
      // Ask for user input
      operation = getOperation();
      if (operation.equals("Q") || operation.equals("q")) {
        // If user input Q or q, quit program.
        quitProgram = true;
        System.out.println("See you soon...");
      }
      else {
        // If user enters a valid operation, they will
        // be asked for two fractions to perform it.
        Fraction newFraction, fraction1, fraction2;

        System.out.print("Please enter a fraction 'a/b' or integer 'a': ");
        userFraction1 = input.readLine();
        fraction1 = getFraction(userFraction1);

        System.out.print("Please enter a fraction 'a/b' or integer 'a': ");
        userFraction2 = input.readLine();
        fraction2 = getFraction(userFraction2);

        // Performing operation on user fractions
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
      }
    }


  } // end main()

  // Method to get user desired operation on fractions.
  public static String getOperation() throws Exception {
    System.out.print("Please enter an operation (+, -, /, *, = or Q to quit): ");
    String operation = input.readLine();

    // Check if the operation is valid comparing with
    // the VALID_OPERATIONS constant.
    boolean inputContains = Arrays.stream(VALID_OPERATIONS).anyMatch(operation::equals);

    while (!inputContains) {
      // Keep asking for correct user input until it's valid.
      System.out.print("Invalid Input (+, -, /, *, = or Q to quit): ");
      operation = input.readLine();
      inputContains = Arrays.stream(VALID_OPERATIONS).anyMatch(operation::equals);
    }

    return operation;
  } // end getOperation() method


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

} // end FractionCalculator Class
