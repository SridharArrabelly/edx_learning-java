public class Variables {
    public static void main(String[] args) {
      // Declaring an two string variables
        String main_str_start = "start main var";
        String main_str_end = "end main var";
        System.out.println(main_str_start);
        method1();
        method2();
        method3();
        System.out.println(main_str_end);
    }

    public static void method1() {
      // Declaring an int variable
        int number_x = 10;
        System.out.println("enter method1");
        System.out.println("end method1 " + number_x);
    }

    public static void method2() {
      // Doing some mathematical operations
        int n1 = 10;
        int n2 = 5;
        System.out.println("start method2");
        System.out.println(n1 + n2);
        System.out.println(n1 * n2);
        System.out.println(n1 - n2);
        System.out.println(n1 / n2);
        System.out.println("end method2");

    }

    public static void method3() {
      // More mathematical operations
        int x = 10;
        System.out.println("enter method3");
        x++;
        System.out.println(x);
        System.out.println(x *= 2);
        System.out.println("end method3");
    }
}
