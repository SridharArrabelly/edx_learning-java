/*
edX Learn Programming with Java
Module 2 Project - Odds or Evens Game

Author: Claudio Castello
http://github.com/claudiocastello

Solution for the second project in the Microsoft introductory course
on Java. Playing around with if/else statements, while loops and logic.

Also, writing some methods to be called with arguments just to practice
and see how it works in Java. Obviously, this small program didn't need
all these methods. It's just for my practice...

The game is similar to rock paper scissors. It is played between two players,
in your version it will be you versus the computer. Each player will choose
either "odds" or "evens", since you’re playing the computer you will get
first pick. Once you have chosen your side, you each choose a number of
fingers to play- 0 to 5. The winner is determined by whether the sum of
your fingers is odd or even (depending on what you chose).

For example, let’s say you choose "evens". That means the computer gets
"odds". You choose to play 2 fingers and the computer plays 3. 2 + 3 = 5,
which is odd so the computer wins.

*/

// Imports
import java.util.Scanner;
import java.util.Random;

public class OddsEvensGame {
  static Scanner input = new Scanner(System.in);
  public static void main(String[] args) {
    // Main method calling another methods and
    // storing some values in variables.
    String user_choice = greetings();

    System.out.println("-------------------------------------------------------");
    System.out.println();

    int user_fingers = user_plays();
    int computer_fingers = computer_plays();

    System.out.println("-------------------------------------------------------");
    System.out.println();

    int sum_num = sum_nums(user_fingers, computer_fingers);

    System.out.println("-------------------------------------------------------");
    System.out.println();

    who_won(user_choice, sum_num);

    System.out.println("-------------------------------------------------------");
    System.out.println();

  }

  public static String greetings() {
    // Greetings method asking for user name and
    // the user choice (odds or evens).
    System.out.println("Let’s play a game called “Odds and Evens");
    System.out.print("What's your name? ");
    String name = input.next();
    System.out.print("Hi " + name + ", which do you choose? (O)dds or (E)vens? ");
    String user_choice = input.next();

    while (!user_choice.equals("O") && !user_choice.equals("E")) {
      System.out.print("Please type 'O for odds or 'E' for even (case sensitive): ");
      user_choice = input.next();
    }

    if (user_choice.equals("O")) {
      System.out.println(name + " has picked 'Odds'. The computer will be 'Evens'.");
    } else {
      System.out.println(name + " has picked 'Evens'. The computer will be 'Odds'.");
    }
    return user_choice;
  }

  public static int user_plays() {
    // Here the users choose with how many fingers they will play.
    System.out.print("How many fingers do you put out? ");
    int user_fingers = input.nextInt();
    while ((user_fingers < 0) || (user_fingers > 5)) {
      System.out.print("You need to choose between 0 and 5? ");
      user_fingers = input.nextInt();
    }
    return user_fingers;
  }

  public static int computer_plays() {
    // Here the number of fingers for computer
    // is randomly chosen.
    Random rand = new Random();
    int computer = rand.nextInt(6);
    System.out.println("The computer plays " + computer + " fingers.");
    return computer;
  }

  public static int sum_nums(int user_f, int comp_f) {
    // A simple sum method returning the sum of the
    // given numbers of fingers from user and computer.
    int num_sum = user_f + comp_f;
    System.out.println(user_f + " + " + comp_f + " = " + num_sum);
    if (num_sum % 2 == 0) {
      System.out.println(num_sum + " is Even!");
    } else {
      System.out.println(num_sum + " is Odd!");
    }
    return num_sum;
  }

  public static void who_won(String oddsOrEven, int sumFromPlayGame) {
    // Another simple method to determine who is the winner.
    if (sumFromPlayGame % 2 == 0) {
      if (oddsOrEven.equals("E")) {
        System.out.println("You wins!");
      } else {
        System.out.println("The computer wins!");
      }
    } else {
      if (oddsOrEven.equals('E')) {
        System.out.println("The computer wins!");
      } else {
        System.out.println("You wins!");
      }
    }
  }
}
