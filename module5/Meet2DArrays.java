import java.util.Arrays;

public class Meet2DArrays {
  public static void main(String[] args) {
    // Declaring a 2D Array
    int[][] new_array = new int[4][4];
    System.out.print("Length of the inner array:");
    System.out.println(new_array.length);
    System.out.print("Length of the outter array:");
    System.out.println(new_array[1].length + "\n");

    // Filling a 2D array
    for (int row = 0; row < new_array.length; row++) {
      for (int col = 0; col < new_array[row].length; col++) {
        if (row == col) {
          new_array[row][col] = 1;
        } else {
          new_array[row][col] = col + row;
        }
      }
    }

    // Printing the 2D array
    for (int row = 0; row < new_array.length; row++) {
      for (int col = 0; col < new_array[row].length; col++) {
        if (col == new_array[row].length - 1) {
          System.out.println(new_array[row][col]);
        } else {
          System.out.print(new_array[row][col] + " ");
        }
      }
    }

  }
}
