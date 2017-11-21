import java.util.Scanner;

public class MazeRunner {
  // Instantiation of new Maze object
  static Maze myMap = new Maze();

  // Instantiation of new Scanner object
  static Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    int move_counter = 0;

    // Greet the user and start the game
    intro();

    // Ask users to choose a direction while myMap.didIWin == false
    while (!myMap.didIWin()) {
      // Call ask_move method for user to choose the desired direction
      ask_move();
      // Increments the move_counter and calls moves_messages()
      // to give users messages about how many moves they have yet.
      move_counter++;
      moves_messages(move_counter);
      // Check if move_counter == 100 and if true break the
      // while loop and the game ends.
      if (move_counter == 100) {
        System.out.println("Sorry, but you didn't escape in time- you lose!");
        break;
      }
    }

    // If user wins the game myMap.didIWin == true
    // and the block below runs.
    if (myMap.didIWin()) {
      System.out.println("Congratulations, you made it out alive!\nYou did it in " + move_counter + " moves.");
    }
  } // end main() method


  public static void intro() {
    System.out.println("Welcome to Maze Runner\nHere is your current position:");
    myMap.printMap();
  } // end intro() method


  public static void ask_move() {
    System.out.print("Choose a direction to move: Right (R), Left (L), Up (U) or Down (D): ");
    String input_move = input.next();
    input_move = input_move.toUpperCase();
    // Keep asking for direction while users did not
    // insert R, L, U or D.
    while (!input_move.equals("R") && !input_move.equals("L") &&
          !input_move.equals("U") && !input_move.equals("D")) {
      System.out.print("Invalid Direction! Type R, L, U or D: ");
      input_move = input.next();
    }
    // Uses the user input to call navigate_pits
    // and test if there is a pit in the chosen
    // direction.
    navigate_pits(input_move);

    // If no pits, call navigate_spaces and move
    // the user in the desired direction.
    navigate_spaces(input_move);

  } // end ask_move() method


  public static void navigate_spaces(String direction) {
    // Test if is a valid direction to move
    // and move the user to that direction.
    if (direction.equals("R") && myMap.canIMoveRight()) {
      myMap.moveRight();
    } else if (direction.equals("L") && myMap.canIMoveLeft()) {
      myMap.moveLeft();
    } else if (direction.equals("U") && myMap.canIMoveUp()) {
      myMap.moveUp();
    } else if (direction.equals("D") && myMap.canIMoveDown()) {
      myMap.moveDown();
    } else {
      System.out.println("Sorry... you've hit a wall. Choose another direction...");
    }
    // Print the map to show user their current position
    myMap.printMap();
  } // end navigate_spaces() method


  public static void navigate_pits(String direction) {
    // Check for a pit in the chosen direction.
    if (myMap.isThereAPit(direction)) {
      // Ask if user wants to jump over the pit.
      System.out.print("Watch out! There's a pit ahead, jump it? ");
      String jump_pit = input.next();
      jump_pit = jump_pit.toLowerCase();
      // If yes, calls method to jump the pit.
      if (jump_pit.substring(0,1).equals("y")) {
        myMap.jumpOverPit(direction);
      } // end if
    } //end if
  } // end navigate_pits() methods



  public static void moves_messages(int moves) {
    // Check number of movements user made and show messages accordingly.
    if (moves == 50) {
      System.out.println("Warning: You have made 50 moves, you have 50 remaining before the maze exit closes");
    } else if (moves == 70) {
      System.out.println("Alert! You have made 75 moves, you only have 25 moves left to escape.");
    } else if (moves == 90) {
      System.out.println("DANGER! You have made 90 moves, you only have 10 moves left to escape!!");
    } else if (moves == 100) {
      System.out.println("Oh no! You took too long to escape, and now the maze exit is closed FOREVER >:[");
    }
  } // end moves_messages() method

} // end MazeRunner class
