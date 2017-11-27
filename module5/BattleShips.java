import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class BattleShips {
  static Scanner input = new Scanner(System.in);
  static Random randomGenerator = new Random();

  public static void main(String[] args) {
    ArrayList map = new ArrayList();
    map = newMap();

    greetings();
    printMap(map);
    System.out.println("");

    deployPlayerShips(map);
    deployComputerShips(map);
    printMap(map);

    battle(map);

  } // end main()

  public static void greetings() {
    System.out.println("**** Welcome to Battle Ships Game ****\nRight now, the sea is empty.");
  } // end greetings() method


  public static ArrayList newMap() {
    ArrayList<ArrayList<String>> sea = new ArrayList<ArrayList<String>>();
    ArrayList<String> x1 = new ArrayList<String>();
    ArrayList<String> x2 = new ArrayList<String>();

    for (int col = 0; col < 14; col++) {
      if (col < 2 || col > 11) {
        x1.add(" ");
      } else {
        x1.add(String.valueOf(col - 2));
      }
    }

    sea.add(x1);

    for (int col = 0; col < 14; col++) {
      if (col == 0 || col == 13) {
        x2.add(String.valueOf(0));
      } else if (col == 1 || col == 12) {
        x2.add("|");
      } else {
        x2.add(" ");
      }
    }

    for (int row = 0; row < 10; row++) {
      ArrayList<String> copyOfx2 = new ArrayList<String>(x2);
      copyOfx2.set(0, String.valueOf(row));
      copyOfx2.set(13, String.valueOf(row));
      sea.add(copyOfx2);
    }

    sea.add(x1);

    return sea;
  } // end newMap() method


  public static void printMap(ArrayList<ArrayList<String>> sea) {
    // ToDo: add code to hide computer ships.
    for (int row = 0; row < sea.size(); row++) {
      for (int col = 0; col < sea.get(row).size(); col++) {
        if (col == sea.get(row).size() - 1) {
          if (sea.get(row).get(col).equals("P")) {
            System.out.println("@ ");
          } else if (sea.get(row).get(col).equals("C")) {
            System.out.println("  ");
          } else {
            System.out.println(sea.get(row).get(col)+" ");
          }
        } else {
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


  public static void deployPlayerShips(ArrayList<ArrayList<String>> sea) {
    int counter = 1;
    System.out.println("Deploy your ships:");

    while (counter <= 5) {
      System.out.print("Enter X Coordinate for ship " + counter + ": ");
      int xCord = input.nextInt();
      while (xCord < 0 || xCord > 9) {
        System.out.print("X coordinate must be a value between [0-9]: ");
        xCord = input.nextInt();
      }

      System.out.print("Enter Y Coordinate for ship " + counter + ": ");
      int yCord = input.nextInt();
      while (yCord < 0 || yCord > 9) {
        System.out.print("Y coordinate must be a value between [0-9]: ");
        yCord = input.nextInt();
      }

      if (sea.get(yCord + 1).get(xCord + 2).equals("P")) {
        System.out.println("You already have a ship at this point.");
        System.out.println("Choose another coordinate to place your ship...");
        continue;
      }
      sea.get(yCord + 1).set(xCord + 2, "P");
      counter++;
    }
    System.out.println("");
  } // end deployPlayerShips() method


  public static void deployComputerShips(ArrayList<ArrayList<String>> sea) {
    int counter = 1;
    int xCord;
    int yCord;

    System.out.println("Deploying computer ships...");

    while (counter <= 5) {
      xCord = randomGenerator.nextInt(10);
      yCord = randomGenerator.nextInt(10);
      if (sea.get(yCord + 1).get(xCord + 2).equals("C")) {
        continue;
      }
      sea.get(yCord + 1).set(xCord + 2, "C");
      System.out.println("Deployed computer Ship " + counter);
      counter++;
    }
    System.out.println("");
  } // end deployComputerShips() method


  public static void battle(ArrayList<ArrayList<String>> sea) {
    int playerShips = 5;
    int computerShips = 5;

    while (playerShips > 0 && computerShips > 0) {
      // Player's turn
      System.out.println("YOUR TURN");

      System.out.print("Enter X Coordinate: ");
      int xCord = input.nextInt();
      while (xCord < 0 || xCord > 9) {
        System.out.print("X coordinate must be a value between [0-9]: ");
        xCord = input.nextInt();
      }

      System.out.print("Enter Y Coordinate: ");
      int yCord = input.nextInt();
      while (yCord < 0 || yCord > 9) {
        System.out.print("Y coordinate must be a value between [0-9]: ");
        yCord = input.nextInt();
      }

      if (sea.get(yCord + 1).get(xCord + 2).equals("C")) {
        System.out.println("Boom! You sunk the ship!");
        sea.get(yCord + 1).set(xCord + 2, "!");
        computerShips--;
      } else if (sea.get(yCord + 1).get(xCord + 2).equals("P")) {
          System.out.println("Oh no, you sunk your own ship :(");
          sea.get(yCord + 1).set(xCord + 2, "X");
          playerShips--;
      } else {
          System.out.println("Sorry, you missed.");
          sea.get(yCord + 1).set(xCord + 2, "-");
      }
      System.out.println("");

      // Computer's turn
      System.out.println("COMPUTER'S TURN");
      int xCordComp = randomGenerator.nextInt(10);
      int yCordComp = randomGenerator.nextInt(10);

      if (sea.get(yCordComp + 1).get(xCordComp + 2).equals("P")) {
        System.out.println("The Computer sunk one of your ships!");
        sea.get(yCordComp + 1).set(xCordComp + 2, "X");
        playerShips--;
      } else if (sea.get(yCordComp + 1).get(xCordComp + 2).equals("C")) {
          System.out.println("The Computer sunk one of its own ships");
          sea.get(yCordComp + 1).set(xCordComp + 2, "!");
          computerShips--;
      } else {
          System.out.println("Computer missed.");
      }
      System.out.println("");

      // Ships balance
      System.out.println("Your ships: " + playerShips + " | Computer ships: " + computerShips);
      System.out.println("");
      printMap(sea);

      // Is there a winner?
      if (playerShips == 0) {
        System.out.println("\nToo bad. You loose the battle!");
      }

      if (computerShips == 0) {
        System.out.println("\nHooray! You won the battle :)");
      }
    } // end while loop
  } // end battle() method

} // end BattleShips class
