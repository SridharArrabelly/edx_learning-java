import java.util.ArrayList;

public class ArrayLists {
  public static void main(String[] args) {
    // Creating an array list
    ArrayList lista = new ArrayList();

    // Filling the list with 4 strings
    for (int i = 0; i <= 4; i++) {
      lista.add("java" + String.valueOf(i));
      System.out.println(lista);
    }
    System.out.println("Size of 'lista' = " + lista.size());

    // Removing values from ArrayList
    lista.remove(2);
    lista.remove("java0");
    System.out.println(lista);
    System.out.println("Size of 'lista' = " + lista.size());

    // Accessing an element in the ArrayList
    System.out.println(lista.get(2));

    // Changing a value in the ArrayList
    lista.set(2, "Changed");
    System.out.println(lista);

    // Looking for an item in the ArrayList
    if (lista.contains("Changed")) {
      System.out.println("The item 'Changed' is in the list!");
      System.out.println("It's index is " + lista.indexOf("Changed"));
    }

  }
}
