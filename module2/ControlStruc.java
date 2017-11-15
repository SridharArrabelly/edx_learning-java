import java.util.Scanner;

public class ControlStruc {
  static Scanner input = new Scanner(System.in);
  public static void main(String[] args){
    poker();
    for_loop();
    nested_for();
    while_loop();
  }

  public static void poker() {
    boolean straight = true;
    boolean flush = true;
    System.out.println("**********");
    if (straight && flush) {
      System.out.println("straight flush");
    } else if (straight) {
      System.out.println("straight");
    } else {
      System.out.println("flush");
    }
    System.out.println("**********");
    System.out.println("");
  }

  public static void for_loop() {
    System.out.println("**********");
    for (int i = 0; i <= 5 ; i++) {
        System.out.println("This is a for loop " + i);
    }
    System.out.println("**********");
    System.out.println("");
  }

  public static void nested_for() {
    System.out.println("**********");
    System.out.println("Nested For Loops");
    for (int row = 1; row <= 5 ; row++) {
      for (int col = 1; col <=5 ; col++ ) {
        if (row == col) {
          System.out.print("1 ");
        } else {
          System.out.print("0 ");
        }
      }
      System.out.println("");
    }
    System.out.println("**********");
    System.out.println("");
  }

  public static void while_loop() {
    System.out.print("Enter yes or no: ");
    String answer = input.next();
    while (!answer.equals("yes") && !answer.equals("no")) {
        System.out.print("This loop will go forever if you do not type 'yes' or 'no': ");
        answer = input.next();
    }
    System.out.println("Thank you!");
  }
}
