import java.util.Arrays;

class MeetArrays {
  public static void main(String[] args) {
    // Declaring an array
    int[] studentGrades = {98, 86, 90};

    // Printing arrays
    System.out.println(studentGrades.length);
    System.out.println(Arrays.toString(studentGrades));

    // Iterating over arrays
    for (int i = 0; i < studentGrades.length; i++ ) {
      System.out.println(studentGrades[i]);
    }

    // Passing arrays as methods parameters
    change_array(studentGrades, 1, 90);
    System.out.println(Arrays.toString(studentGrades));

    // Reference Semantics
    // New array x declared "copying" array studentGrades
    int[] x = studentGrades;
    System.out.println("Before Change");
    System.out.println(Arrays.toString(studentGrades));
    System.out.println(Arrays.toString(x));
    // Changes are made in array x
    change_array(x, 1, 89);
    System.out.println("After Change");
    // Changes affect array studentGrades
    System.out.println(Arrays.toString(studentGrades));
    System.out.println(Arrays.toString(x));

    // Now really copying the array
    int[] y = Arrays.copyOf(studentGrades, studentGrades.length);
    System.out.println("Before Change");
    System.out.println(Arrays.toString(studentGrades));
    System.out.println(Arrays.toString(y));
    // Changes are made in array x
    change_array(x, 1, 70);
    System.out.println("After Change");
    // Changes affect array studentGrades
    System.out.println(Arrays.toString(studentGrades));
    System.out.println(Arrays.toString(y));

  }

  public static void change_array(int[] array, int index, int value) {
    array[index] = value;
  }

}
