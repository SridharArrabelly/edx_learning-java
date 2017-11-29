/*
 * Author: Claudio Castello
 * Github: http://github.com/claudiocastello
 *
 * Object Oriented Programming in java
 * Module 1 Project - Battle Ship Game
 *
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;


public class BattleShips {
  /*
   * Creating Scanner and Random objects
   * These objects will be used in more than
   * one method.
   */
  static Scanner input = new Scanner(System.in);
  static Random randomGenerator = new Random();


  public static void main(String[] args) {
    /* Creating ArrayList object to represent the map of the game. */
    ArrayList map = new ArrayList();

    /* newMap method is called to create the map */
    map = newMap();

    System.out.println("**** Welcome to Battle Ships Game ****\nRight now, the sea is empty.");
    printMap(map);
    System.out.println("");

    /* The map is populated with ships from player and computer. */
    deployPlayerShips(map);
    deployComputerShips(map);
    printMap(map);

    /*  Method for battle is called. */
    battle(map);

  } // end main()


  /*
  * This method creates the empty map to start the Game
  * An empty map example is showed below.
  *
  *            0 1 2 3 4 5 6 7 8 9
  *        0 |                     | 0
  *        1 |                     | 1
  *        2 |                     | 2
  *        3 |                     | 3
  *        4 |                     | 4
  *        5 |                     | 5
  *        6 |                     | 6
  *        7 |                     | 7
  *        8 |                     | 8
  *        9 |                     | 9
  *            0 1 2 3 4 5 6 7 8 9
  */
  public static ArrayList newMap() {
    /* Create 2D ArrayList to represent the map of the game. */
    ArrayList<ArrayList<String>> sea = new ArrayList<ArrayList<String>>();

    /* Creates ArrayLists to be used as sublists of the map ArrayList */
    ArrayList<String> x1 = new ArrayList<String>();
    ArrayList<String> x2 = new ArrayList<String>();

    /* Creates the list to be used as first and last lines of the map */
    for (int col = 0; col < 14; col++) {
      if (col < 2 || col > 11) {
        x1.add(" ");
      } else {
        x1.add(String.valueOf(col - 2));
      }
    }

    /* Add the first line of the map */
    sea.add(x1);

    /*
     * Create the generic list to be used in the middle
     * of the map (lines 2 to 13)
     */
    for (int col = 0; col < 14; col++) {
      if (col == 0 || col == 13) {
        x2.add(String.valueOf(0));
      } else if (col == 1 || col == 12) {
        x2.add("|");
      } else {
        x2.add(" ");
      }
    }

    /*
     * Changes the first and last character of
     * lines 2 to 13 to the map, according to the
     * index row between [0-9] and add one at a time
     * to the map.
     */
    for (int row = 0; row < 10; row++) {
      ArrayList<String> copyOfx2 = new ArrayList<String>(x2);
      copyOfx2.set(0, String.valueOf(row));
      copyOfx2.set(13, String.valueOf(row));
      sea.add(copyOfx2);
    }

     /* Add the last line to the map */
    sea.add(x1);

    return sea;
  } // end newMap() method


  /*
   * This method get the sea object and iterates through it
   * printing each position of the 2D ArrayList. The map is
   * being manipulated throughout the game and the printMap()
   * when called get always the last version of the map.
   */
  public static void printMap(ArrayList<ArrayList<String>> sea) {
    for (int row = 0; row < sea.size(); row++) {              // Iterates through each row
      for (int col = 0; col < sea.get(row).size(); col++) {   // Iterates through each column of a row
        if (col == sea.get(row).size() - 1) {
          /*
           * This block of code only executes when the inner loop
           * reaches the last position in the inner list. It makes
           * the program to print the last item and start a new line.
           */
          if (sea.get(row).get(col).equals("P")) {
            /*
             * Before the battle the player choose where to put their ships
             * in the map. This block checks if there's a player ship 'P' in
             * the map and prints an '@' on it.
             */
            System.out.println("@ ");
          } else if (sea.get(row).get(col).equals("C")) {
            /*
             * After the player, the computer randomly place their ships
             * in the map "C". The following code makes the computer ships
             * invisible to the player printing an space string " ".
             */
            System.out.println("  ");
          } else {
            /*
             * If a 'P' or a 'C' is not found in the map, the method
             * prints what is the list at the given position.
             */
            System.out.println(sea.get(row).get(col)+" ");
          }
        } else {
          /*
           * This block will execute while the inner loop did't reach
           * the end of the inner list. All the code inside this block
           * is identical to the code in the if block above.
           */
          if (sea.get(row).get(col).equals("P")) {
            System.out.print("@ ");
          } else if (sea.get(row).get(col).equals("C")) {
            System.out.print("  ");
          } else {
            System.out.print(sea.get(row).get(col)+" ");
          }
        }
      }
    }
    System.out.println("");
  } // end printMap() method


  /*
   * The next method is is called to place player's ships in the map.
   * It receive the map as parameter and updates it given the coordinates
   * the users give for their ships.
   */
  public static void deployPlayerShips(ArrayList<ArrayList<String>> sea) {
    /* Initialize a counter to count player ships */
    int counter = 1;
    System.out.println("Deploy your ships:");

    while (counter <= 5) {
      /* This outer while loop runs until the user place 5 ships in the map. */
      System.out.print("Enter X Coordinate for ship " + counter + ": ");

      /*
       * Creates the Scanner variable for the X coordinate,
       * ask for player to insert it and checks if it's inside the map.
       */
      int xCord = input.nextInt();
      while (xCord < 0 || xCord > 9) {
        System.out.print("X coordinate must be a value between [0-9]: ");
        xCord = input.nextInt();
      }

      /*
       * Creates the Scanner variable for the Y coordinate,
       * ask for player to insert it and checks if it's inside the map.
       */
      System.out.print("Enter Y Coordinate for ship " + counter + ": ");
      int yCord = input.nextInt();
      while (yCord < 0 || yCord > 9) {
        System.out.print("Y coordinate must be a value between [0-9]: ");
        yCord = input.nextInt();
      }

      /*
       * Given the (X,Y) coordinates, check if there is already
       * a ship in that point. Notify the player if there is a
       * ship, skip the counter in the next lines and start the loop
       * again asking for new coordinates.
       */
      if (sea.get(yCord + 1).get(xCord + 2).equals("P")) {
        System.out.println("You already have a ship at this point.");
        System.out.println("Choose another coordinate to place your ship...");
        continue;
      }

      /*
       * If the coordinates are valid and there's no ship in that point
       * adds the ship 'P' there and increase the counter by 1.
       */
      sea.get(yCord + 1).set(xCord + 2, "P");
      counter++;
    }
    System.out.println("");
  } // end deployPlayerShips() method


  /*
   * The next method is called to place computer ships in the map.
   * It randomly generates the (X,Y) coordinates and place the ship
   * in that point if there's no player's ship there.
   */
  public static void deployComputerShips(ArrayList<ArrayList<String>> sea) {
    /*
     * Initialize the counter for computer ships and
     * the X and Y coordinates variables.
     */
    int counter = 1;
    int xCord;
    int yCord;

    System.out.println("Deploying computer ships...");

    while (counter <= 5) {
      /*
       * This outer while loop runs until the user place 5 ships in the map.
       * X and Y coordinates are randomly generated by the Random object.
       */
      xCord = randomGenerator.nextInt(10);
      yCord = randomGenerator.nextInt(10);


      if (sea.get(yCord + 1).get(xCord + 2).equals("C")
          || sea.get(yCord + 1).get(xCord + 2).equals("P")) {
      /*
       * Given the (X,Y) coordinates, check if there is already
       * a ship in that point ('C' or 'P').
       * Skip the counter in the next lines if there is a ship
       * and start the loop again o generate new coordinates.
       */
        continue;
      }

      /*
       * If the coordinates are valid and there's no ship in that point
       * adds the ship 'C' there and increase the counter by 1.
       */
      sea.get(yCord + 1).set(xCord + 2, "C");
      System.out.println("Deployed computer Ship " + counter);
      counter++;
    }
    System.out.println("");
  } // end deployComputerShips() method


  /*
   * The next method is the game battle itself. After the player and
   * computer place their ships they are ready to start the battle.
   * They alternate turns trying to guess where the enemy ships were
   * placed. The winner is the one who destroy all enemies ships first.
   */
  public static void battle(ArrayList<ArrayList<String>> sea) {
    /*
     * Declaring two int variables to keep count of
     * player and computer ships.
     */
    int playerShips = 5;
    int computerShips = 5;

    /*
     * While loop to keep game running while ships of
     * player and computer are different from zero.
     */
    while (playerShips > 0 && computerShips > 0) {
      /*** Player's turn ***/
      System.out.println("YOUR TURN");

      /*
       * Creates the Scanner variable for the X coordinate,
       * ask for player to insert it and checks if it's inside the map.
       */
      System.out.print("Enter X Coordinate: ");
      int xCord = input.nextInt();
      while (xCord < 0 || xCord > 9) {
        System.out.print("X coordinate must be a value between [0-9]: ");
        xCord = input.nextInt();
      }

      /*
       * Creates the Scanner variable for the Y coordinate,
       * ask for player to insert it and checks if it's inside the map.
       */
      System.out.print("Enter Y Coordinate: ");
      int yCord = input.nextInt();
      while (yCord < 0 || yCord > 9) {
        System.out.print("Y coordinate must be a value between [0-9]: ");
        yCord = input.nextInt();
      }

      /*
       * Having the player chosen the correct coordinates,
       * it's time to test if there's a ship at this point.
       */
      if (sea.get(yCord + 1).get(xCord + 2).equals("C")) {
        /*
         * If in the coordinate chosen there's a computer
         * ship 'C', it prints out to the player his success,
         * adds a '!' in the place of the computer's ship
         * and deacrese the computer's ship counter by 1.
         */
        System.out.println("Boom! You sunk the ship!");
        sea.get(yCord + 1).set(xCord + 2, "!");
        computerShips--;
      } else if (sea.get(yCord + 1).get(xCord + 2).equals("P")) {
        /*
         * If in the coordinate chosen there's a player
         * ship 'P', it prints out to the player his failure,
         * adds a 'X' in the place of the player's ship
         * and deacrese the player's ship counter by 1.
         */
          System.out.println("Oh no, you sunk your own ship :(");
          sea.get(yCord + 1).set(xCord + 2, "X");
          playerShips--;
      } else {
        /*
         * If there's no ship in the chosen coordinate
         * it prints out to the player that he missed
         * and adds a '-' to that coordinate.
         */
          System.out.println("Sorry, you missed.");
          sea.get(yCord + 1).set(xCord + 2, "-");
      }
      System.out.println("");

      /*** Computer's turn ***/
      System.out.println("COMPUTER'S TURN");

      /*
       * Generate a random coordinate for computer to play.
       * The computer never get a coordinate outside the map
       * so it's not necessary to test for this.
       */
      int xCordComp = randomGenerator.nextInt(10);
      int yCordComp = randomGenerator.nextInt(10);

      if (sea.get(yCordComp + 1).get(xCordComp + 2).equals("P")) {
        /*
         * If in the generated coordinate there's a player
         * ship 'P', it prints out to the player the computer
         * success, adds a 'X' in the place of the player's ship
         * and deacrese the player's ship counter by 1.
         */
        System.out.println("The Computer sunk one of your ships!");
        sea.get(yCordComp + 1).set(xCordComp + 2, "X");
        playerShips--;
      } else if (sea.get(yCordComp + 1).get(xCordComp + 2).equals("C")) {
        /*
         * If in the generated coordinate there's a player
         * ship 'C', it prints out to the player the computer
         * failure, adds a '!' in the place of the computer's ship
         * and deacrese the computer's ship counter by 1.
         */
          System.out.println("The Computer sunk one of its own ships");
          sea.get(yCordComp + 1).set(xCordComp + 2, "!");
          computerShips--;
      } else {
        /*
         * If there's no ship in the generated coordinate
         * it prints out to the player that the Computer missed
         */
          System.out.println("Computer missed.");
      }
      System.out.println("");

      /* Prints player's and computer's ships balance */
      System.out.println("Your ships: " + playerShips + " | Computer ships: " + computerShips);
      System.out.println("");
      printMap(sea);

      /*
       * Is there a winner?
       * Checks if player's ships or computer ships
       * is zero and declare a winner based on it.
       */
      if (playerShips == 0) {
        System.out.println("\nToo bad. You loose the battle!");
      }
      if (computerShips == 0) {
        System.out.println("\nHooray! You won the battle :)");
      }
    } // end while loop
  } // end battle() method

} // end BattleShips class
