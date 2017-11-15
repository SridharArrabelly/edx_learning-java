import java.util.Scanner;

public class InterativeProgram {
    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      System.out.println("Welcome. What's your name?");
      String name = input.next();
      System.out.println("How old are you?");
      int age = input.nextInt();
      System.out.println("What's your height?");
      double height = input.nextDouble();
      System.out.println(name + " is " + age + " year old and is " + height + "m tall");
    }
}
